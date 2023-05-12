// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.SwerveDrivetrain;

public class DriveWithJoysticks extends CommandBase {
  private final Supplier<Double> xSpeed, ySpeed, turnSpeed;
  private final SwerveDrivetrain drivetrain;

  public DriveWithJoysticks(SwerveDrivetrain drivetrain, Supplier<Double> xSpeed, Supplier<Double> ySpeed, Supplier<Double> turnSpeed) {
    this.drivetrain = drivetrain;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
    this.turnSpeed = turnSpeed;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    ChassisSpeeds chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed.get(), ySpeed.get(), turnSpeed.get(), drivetrain.getHeading());
    drivetrain.setModuleStates(drivetrain.getKinematics().toSwerveModuleStates(chassisSpeeds));
  }
}
