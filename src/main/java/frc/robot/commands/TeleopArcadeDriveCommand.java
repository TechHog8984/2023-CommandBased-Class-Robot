// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TeleopArcadeDriveCommand extends CommandBase {
  private final DriveSubsystem mDriveSubsystem;
  private final Joystick mJoyStick;
  public TeleopArcadeDriveCommand(DriveSubsystem drive_subsystem, Joystick joystick) {
    addRequirements(drive_subsystem);

    mDriveSubsystem = drive_subsystem;
    mJoyStick = joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left_y_input = mJoyStick.getRawAxis(0);
    double right_x_input = mJoyStick.getRawAxis(1);

    if (Math.abs(left_y_input) > 0.1 && Math.abs(right_x_input) > 0.1) {
      mDriveSubsystem.arcadeDrive(left_y_input, right_x_input);
    } else {
      mDriveSubsystem.arcadeDrive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
