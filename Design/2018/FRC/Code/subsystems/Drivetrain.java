/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.subsystems;


import org.usfirst.frc.team6360.robot.Robot;
import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.Drivetrain_ArcadeDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
/**
 *
 * TankDrive and ArcadeDrive
 *
 */
public class Drivetrain extends Subsystem {
	edu.wpi.first.wpilibj.Encoder leftEncoder = new edu.wpi.first.wpilibj.Encoder(3, 4,true);
	//3 IS FOR THE IOADXRS450_GyroNE WITH LESS WIRE
	//edu.wpi.first.wpilibj.Encoder rightEncoder = new edu.wpi.first.wpilibj.Encoder(5, 6,false);
	
	TalonSRX c1 = new TalonSRX(1);
	TalonSRX c2 = new TalonSRX(2);
	TalonSRX c3 = new TalonSRX(3);
	TalonSRX c4 = new TalonSRX(4);
	
	AnalogInput dis = new AnalogInput(1);
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	   /* AcradeDrive Speed Controller
	    * @param speed
	    * @param rotation
	    */
	  protected double limit(double value) {
		    if (value > 1.0) {
		      return 1.0;
		    }
		    if (value < -1.0) {
		      return -1.0;
		    }
		    return value;
		  }
	   public void setArcadeDrive(double speed, double rotation) {
		   double leftMotorOutput;
		    double rightMotorOutput;
		    double xSpeed = speed;
		    double zRotation = rotation;
		    double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);
		    if (xSpeed >= 0.0) {
		      // First quadrant, else second quadrant
		      if (zRotation >= 0.0) {
		        leftMotorOutput = maxInput;
		        rightMotorOutput = xSpeed - zRotation;
		      } else {
		        leftMotorOutput = xSpeed + zRotation;
		        rightMotorOutput = maxInput;
		      }
		    } else {
		      // Third quadrant, else fourth quadrant
		      if (zRotation >= 0.0) {
		        leftMotorOutput = xSpeed + zRotation;
		        rightMotorOutput = maxInput;
		      } else {
		        leftMotorOutput = maxInput;
		        rightMotorOutput = xSpeed - zRotation;
		      }
		    }
		    c1.set(ControlMode.PercentOutput,limit(leftMotorOutput) * 1);
		    c2.set(ControlMode.PercentOutput,limit(leftMotorOutput) * 1);
		    c3.set(ControlMode.PercentOutput,-limit(rightMotorOutput) * 1);
		    c4.set(ControlMode.PercentOutput,-limit(rightMotorOutput) * 1);
		  }
		
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
//	   public Encoder getRightEncoder() {
//		   return rightEncoder;
//	   }
	   public Encoder getLeftEncoder() {
		   return leftEncoder;
	   }
	   public AnalogInput getDis() {
		   return dis;
	   }
	   public ADXRS450_Gyro getGyro() {
		   return gyro;
   }
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new Drivetrain_TankDrive());
		setDefaultCommand(new Drivetrain_ArcadeDrive());
	}
}
