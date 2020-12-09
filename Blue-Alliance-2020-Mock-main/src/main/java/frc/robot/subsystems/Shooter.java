package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import frc.robot.RobotMap;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private PWMTalonSRX shootTalon = new PWMTalonSRX(RobotMap.extenderPort);
  private PWMTalonSRX lift = new PWMTalonSRX(RobotMap.liftPort);
  
  public static Shooter shootInstance;

  public Shooter() {
    lift.setInverted(true);
  }

  public static Shooter getInstance() {
    if (shootInstance == null) {
      shootInstance = new Shooter();
    }
    return shootInstance;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

 

  @Override
  public void periodic() {

    //Arm extension
    if (OI.returnController().getRawButton(RobotMap.leftBumper)) {
      shootTalon.set(0.1);
    } else if (OI.returnController().getRawButton(RobotMap.rightBumper)) {
      shootTalon.set(-0.1);
    } else {
      shootTalon.set(0);
    }

  
  }
}