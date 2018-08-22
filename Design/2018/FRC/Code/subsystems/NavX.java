/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.subsystems;



import java.nio.channels.Channel;
import java.text.BreakIterator;

import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.Drivetrain_ArcadeDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
 
public class NavX extends Subsystem {
	 
//	private AHRS ahrs= new AHRS(SPI.Port.kMXP); 
	//	AHRS ahrs= new AHRS(SerialPort.Port.kUSB ); 
	//private AHRS ahrs= new AHRS(SerialPort.Port.kMXP);
	BuiltInAccelerometer builtInAccelerometer = new BuiltInAccelerometer();
	  double last_world_linear_accel_y;
//	  AnalogInput Ultrasonic = new AnalogInput(0);
//	  VictorSP pwn_out_0;
//    pwn_out_0 = new VictorSP(getChannelFromPin(PinType.PWM,0));	 
//	  public enum PinType { DigitalIO, PWM, AnalogIn, AnalogOut };
//	  public int getChannelFromPin(PinType type,int io_pin_number) {
//		 int Channel = 0;  
//		 switch(type){ 
//		 case PWM:
//			 if(io_pin_number>9) {
//				 throw new IllegalArgumentException("error");
//			 }
//			   Channel = io_pin_nu\mber;	 
//			  break;
//		 case AnalogIn:
//			 if(io_pin_number>3) {
//				 throw new IllegalArgumentException("error");
//			 }
//			 Channel = io_pin_number;
//		 }
//		  return Channel ;		  
//		  }
	 public boolean getCollison() {
		
         double curr_world_linear_accel_y =builtInAccelerometer.getY();

         double currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;

         last_world_linear_accel_y = curr_world_linear_accel_y;
		 if(
				 (Math.abs(currentJerkY)>1.6)
			) {
			 return true;
		 }
		return false; 
	 }
		
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here
	}

	public BuiltInAccelerometer getBuilt() {
		return builtInAccelerometer;
	}
//	public AnalogInput getUltrasonic() {
//		return Ultrasonic;
//	}
}
