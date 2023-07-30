// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TimedArcadeDriveCommand extends CommandBase {

  private final Timer mTimer = new Timer();

  private final DriveSubsystem mDriveSubsystem;
  private final double m_time_goal;
  private final double m_forward_power;
  private final double m_turn_power;

  public TimedArcadeDriveCommand(DriveSubsystem drive_subsystem, double time_seconds, double forward_power, double turn_power) {
    addRequirements(drive_subsystem);

    mDriveSubsystem = drive_subsystem;
    m_time_goal = time_seconds;
    m_forward_power = forward_power;
    m_turn_power = turn_power;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mTimer.restart();
    mDriveSubsystem.arcadeDrive(m_forward_power, m_turn_power);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mTimer.stop();
    mDriveSubsystem.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return mTimer.get() >= m_time_goal;
  }
}
