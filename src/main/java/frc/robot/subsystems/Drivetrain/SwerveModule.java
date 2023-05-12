package frc.robot.subsystems.Drivetrain;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.RobotContainer;

public class SwerveModule {
    private final CANSparkMax driveMotor;
    private final CANSparkMax turnMotor;
    private final RelativeEncoder driveEncoder;
    private final RelativeEncoder turnEncoder;
    private final AnalogInput absoluteEncoder;
    private final PIDController turnPIDController;
    private final boolean absoluteEncoderInverted;
    private final double absoluteEncoderOffset;
    

    public SwerveModule(int driveMotorID, int turnMotorID, boolean driveInverted, boolean turnInverted, int absoluteEncoderID, double absoluteEncoderOffset, boolean absoluteEncoderInverted) {
        driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
        turnMotor = new CANSparkMax(turnMotorID, MotorType.kBrushless);

        driveMotor.setInverted(driveInverted);
        turnMotor.setInverted(turnInverted);

        driveEncoder = driveMotor.getEncoder();
        turnEncoder = turnMotor.getEncoder();

        absoluteEncoder = new AnalogInput(absoluteEncoderID);

        this.absoluteEncoderInverted = absoluteEncoderInverted;
        this.absoluteEncoderOffset = absoluteEncoderOffset;

        turnPIDController = new PIDController(0.001, 0, 0);
        turnPIDController.enableContinuousInput(-Math.PI, Math.PI);

        resetEncoders();
    }

    public SwerveModulePosition getPosition() {
        return new SwerveModulePosition();
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(driveEncoder.getVelocity(), new Rotation2d(turnEncoder.getPosition()));
    }

    public void setDesiredState(SwerveModuleState state) {
        if(state.speedMetersPerSecond < 0.001) {
            stop();
            return;
        }

        state = SwerveModuleState.optimize(state, new Rotation2d(turnEncoder.getPosition()));
        driveMotor.set(state.speedMetersPerSecond / 5d);
        turnMotor.set(turnPIDController.calculate(turnEncoder.getPosition(), state.angle.getRadians()));
    }

    public void stop() {
        driveMotor.set(0);
        turnMotor.set(0);
    }

    public double getAbsoluteEncoderPosition() {
        double angle = absoluteEncoder.getVoltage() / RobotController.getVoltage5V();
        angle *= 2d * Math.PI;
        angle -= absoluteEncoderOffset;
        return angle * (absoluteEncoderInverted ? -1d : 1d);
    }

    public void resetEncoders() {
        driveEncoder.setPosition(0);
        turnEncoder.setPosition(getAbsoluteEncoderPosition());
    }
}
