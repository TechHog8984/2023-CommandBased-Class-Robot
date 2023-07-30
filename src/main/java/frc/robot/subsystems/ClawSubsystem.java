// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSubsystem extends SubsystemBase {
  private final DoubleSolenoid mActuator = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  private final DigitalInput mClicker0 = new DigitalInput(0);
  private final DigitalInput mClicker1 = new DigitalInput(1);

  public ClawSubsystem() {}

  public void actuateForward() {
    mActuator.set(DoubleSolenoid.Value.kForward);
  }
  public void actuateReverse() {
    mActuator.set(DoubleSolenoid.Value.kReverse);
  }

  public boolean getClicker0() {
    return mClicker0.get();
  }
  public boolean getClicker1() {
    return mClicker1.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
