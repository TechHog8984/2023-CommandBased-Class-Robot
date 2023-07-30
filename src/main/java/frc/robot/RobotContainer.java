// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.AutoCommandGroup1;
import frc.robot.commands.TeleopArcadeDriveCommand;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final DriveSubsystem mDriveSubsystem = new DriveSubsystem();
  private final ClawSubsystem mClawSubsystem = new ClawSubsystem();

  private final Joystick mDriverJoystick = new Joystick(1);
  private final JoystickButton mDriveButton1 = new JoystickButton(mDriverJoystick, 1);
  private final Trigger mClawClicker0Trigger = new Trigger(mClawSubsystem::getClicker0);
  private final Trigger mClawClicker1Trigger = new Trigger(mClawSubsystem::getClicker1);

  private final InstantCommand mClawForwardCommand = new InstantCommand(mClawSubsystem::actuateForward, mClawSubsystem);
  private final InstantCommand mClawReverseCommand = new InstantCommand(mClawSubsystem::actuateReverse, mClawSubsystem);

  public RobotContainer() {
    mDriveSubsystem.setDefaultCommand(new TeleopArcadeDriveCommand(mDriveSubsystem, mDriverJoystick));
    configureBindings();
  }

  private void configureBindings() {
    mDriveButton1.onTrue(mClawForwardCommand).onFalse(mClawReverseCommand);

    mClawClicker0Trigger.onTrue(mClawForwardCommand);
    mClawClicker1Trigger.onTrue(mClawReverseCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutoCommandGroup1(mDriveSubsystem);
  }
}
