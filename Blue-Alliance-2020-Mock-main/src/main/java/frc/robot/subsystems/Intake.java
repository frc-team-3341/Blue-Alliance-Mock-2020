/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
//import sun.security.jca.GetInstance;
import frc.robot.OI;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  private PWMTalonSRX intake = new PWMTalonSRX(RobotMap.intakePort);
  private boolean Intake, Outtake;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  @Override
  public void periodic() {
  Intake = OI.getArcJoy().getRawButton(3);
  Outtake = OI.getArcJoy().getRawButton(4);
   if (Intake) {
     intake.set(0.2);
   }
   if (Outtake) {
     intake.set(-0.2);
   }
  }
}
