/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax l1;
  CANSparkMax l2;
  CANSparkMax r1;
  CANSparkMax r2;
  
  public Drive()
  {
    l1 = new CANSparkMax(15, MotorType.kBrushless);
    l2 = new CANSparkMax(14, MotorType.kBrushless);
    r1 = new CANSparkMax(12, MotorType.kBrushless);
    r2 = new CANSparkMax(13, MotorType.kBrushless);
    
    l2.follow(l1);
    r2.follow(r1);

    r1.setInverted(true);

    r1.setIdleMode(IdleMode.kCoast);
    l1.setIdleMode(IdleMode.kCoast);
    r2.setIdleMode(IdleMode.kCoast);
    l2.setIdleMode(IdleMode.kCoast);

  }

  public void moveLeft(double speed)
  {
    l1.set(speed);
  
  }
  public void moveRight(double speed)
  {
    r1.set(speed);
    SmartDashboard.putNumber("right motor speed", speed);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
