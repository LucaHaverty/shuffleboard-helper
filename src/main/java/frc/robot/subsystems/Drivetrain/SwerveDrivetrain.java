// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain;

import java.nio.channels.AsynchronousServerSocketChannel;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDrivetrain extends SubsystemBase {

  SwerveModule frontLeft = new SwerveModule(0, 0, false, false, 0, 0, false);
  SwerveModule frontRight = new SwerveModule(0, 0, false, false, 0, 0, false);
  SwerveModule backLeft = new SwerveModule(0, 0, false, false, 0, 0, false);
  SwerveModule backRight = new SwerveModule(0, 0, false, false, 0, 0, false);
  private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(new Translation2d(-1, 1), new Translation2d(1, 1), new Translation2d(-1, -1), new Translation2d(-1, -1));
  private final AHRS gyro = new AHRS(); 

  /** Creates a new SwerveDrivetrain. */
  public SwerveDrivetrain() {
    new Thread(() -> {
      try {
        Thread.sleep(1000);
        zeroHeading();
      } catch (Exception e) { }
    }).start();

    //odometry = new SwerveDriveOdometry(kinematics, new Rotation2d(), positions, )
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void zeroHeading() {
    gyro.reset();
  }

  public Rotation2d getHeading() {
    return new Rotation2d(Math.toRadians(gyro.getAngle()));
  }

  public void setModuleStates(SwerveModuleState[] states) {
    SwerveDriveKinematics.desaturateWheelSpeeds(states, 5.0);

    frontLeft.setDesiredState(states[0]);
    frontRight.setDesiredState(states[1]);
    backLeft.setDesiredState(states[2]);
    backRight.setDesiredState(states[3]);
  }

  public SwerveDriveKinematics getKinematics() {
    return kinematics;
  }
}
