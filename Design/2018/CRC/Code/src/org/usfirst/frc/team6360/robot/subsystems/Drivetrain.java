/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.subsystems;


import org.usfirst.frc.team6360.robot.Robot;
import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.Drivetrain_arcadeDrive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**TankDrive and ArcadeDrive*/
public class Drivetrain extends Subsystem {
	edu.wpi.first.wpilibj.Encoder leftEncoder = new edu.wpi.first.wpilibj.Encoder(3, 4,true);
	//3 IS FOR THE IONE WITH LESS WIRE
	//edu.wpi.first.wpilibj.Encoder rightEncoder = new edu.wpi.first.wpilibj.Encoder(5, 6,false);
	
	VictorSP m_frontLeft = new VictorSP(RobotMap.leftFront_MotorChannel);
	VictorSP m_rearLeft = new VictorSP(RobotMap.leftRear_MotorChannel);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
	
	VictorSP m_frontRight = new VictorSP(RobotMap.rightFront_MotorChannel);
	VictorSP m_rearRight = new VictorSP(RobotMap.rightRear_MotorChannel);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
   
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	public Drivetrain() {
		System.out.println(RobotMap.drivetrainMessage);
	}
   
   
   
   public DifferentialDrive myDrive = new DifferentialDrive(m_left, m_right);
	
	   /**
	    * TankDrive Speed Controller
	    * @param left left speed
	    * @param right left speed
	    */
	   public void setTankDrive(double left, double right) {
		   myDrive.tankDrive(left, right);
	   }
	   
	   /**
	    * AcradeDrive Speed Controller
	    * @param speed
	    * @param rotation
	    */
	   public void setArcadeDrive(double speed, double rotation) {
		   myDrive.arcadeDrive(speed, rotation,true);
	   }
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
//	   public Encoder getRightEncoder() {
//		   return rightEncoder;
//	   }
	   public Encoder getLeftEncoder() {
		   return leftEncoder;
	   }
	   
	   public ADXRS450_Gyro getGyro() {
		   return gyro;
   }
	   
	   public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new Drivetrain_TankDrive());
		setDefaultCommand(new Drivetrain_arcadeDrive());
	}
}
