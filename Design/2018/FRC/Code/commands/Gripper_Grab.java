/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team6360.robot.OI;
import org.usfirst.frc.team6360.robot.Robot;


public class Gripper_Grab extends Command {
	boolean disDection = false;
	public Gripper_Grab(boolean disDection) {
		requires(Robot.gripper);
		this.disDection = disDection;
	}

	public Gripper_Grab() {
		// TODO Auto-generated constructor stub
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.gripper.grab();
		
//		System.out.println(Robot.visionProcess.getCenterX());
	
	}
 
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(disDection ==true) {
		if(Robot.drivetrain.getDis().getVoltage()<=1.3) {
			return true;
		}
	} 
		return false;
	}
	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.gripper.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
