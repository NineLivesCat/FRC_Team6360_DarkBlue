/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.subsystems;



import org.usfirst.frc.team6360.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {
	
	VictorSP Vict3 = new VictorSP(RobotMap.gripper_Motor3Channel);
	VictorSP Vict4 = new VictorSP(RobotMap.lift_Motor4Channel);
//	VictorSP Vict4 = new VictorSP(RobotMap.gripper_Motor4Channel);
	
	
	public Gripper() {
		System.out.println(RobotMap.gripperMessage);
	}
	
	public void grab() {
		Vict3.set(-RobotMap.GripperMotor_Speed);
//		Vict4.set(RobotMap.GripperMotor_Speed);
	}
	
	public void release() {
		Vict3.set(RobotMap.GripperMotor_Speed);
//		Vict4.set(-RobotMap.GripperMotor_Speed);
	}
	
	public void stop() {
		Vict3.set(0);
		Vict4.set(0);
		
	}
	
	public void up() {
		Vict4.set(RobotMap.lift_Speed);
	}
	
	public void down() {
		Vict4.set(-RobotMap.lift_Speed);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new IsTankDrive());

	}
}
