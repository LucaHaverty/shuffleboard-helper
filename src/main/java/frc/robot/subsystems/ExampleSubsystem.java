// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ShuffleboardHelper;


public class ExampleSubsystem extends SubsystemBase {

  double x = 0;
  public ExampleSubsystem() {
    ShuffleboardHelper.addMotorInfo("Example Motor", ShuffleboardHelper.exampleTab, new CANSparkMax(0, MotorType.kBrushless), 0, 1);
    ShuffleboardHelper.addOutput("Speed Display", ShuffleboardHelper.exampleTab, () -> x).withPos(0, 0).asNumberBar(0, 1).withSize(2, 1);
    ShuffleboardHelper.addInput("Speed Setter", ShuffleboardHelper.exampleTab, (num) -> x = num).withPos(2, 0).asNumberSlider(0, 1).withSize(2, 1);
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {

  }
}
