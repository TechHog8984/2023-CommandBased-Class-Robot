// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCommandGroup1 extends SequentialCommandGroup {
  /** Creates a new AutoCommandGroup1. */
  public AutoCommandGroup1(DriveSubsystem drive_subsystem) {
    addCommands(
      new TimedArcadeDriveCommand(drive_subsystem, 4, 0.2, 0),
      new TimedArcadeDriveCommand(drive_subsystem, 4, -0.2, 0)
    );
  }
}
