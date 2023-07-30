// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final CANSparkMax mLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax mRightMotor = new CANSparkMax(2, MotorType.kBrushless);

  public DriveSubsystem() {}

  public void arcadeDrive(double forward_power, double turn_power) {
    double left_power = forward_power - turn_power;
    double right_power = forward_power + turn_power;

    mLeftMotor.set(left_power);
    mRightMotor.set(-right_power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
