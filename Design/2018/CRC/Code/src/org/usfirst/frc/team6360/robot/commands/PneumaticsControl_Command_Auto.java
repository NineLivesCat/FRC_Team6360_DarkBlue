/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team6360.robot.OI;
import org.usfirst.frc.team6360.robot.Robot;


public class PneumaticsControl_Command_Auto extends Command {
	public PneumaticsControl_Command_Auto() {
		requires(Robot.pneumaticsControl);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		if(Robot.pneumaticsControl.getStatus()) {
			Robot.pneumaticsControl.release();
		}
		else {
			Robot.pneumaticsControl.keep();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Robot.pneumaticsControl.getStatus();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		if(Robot.pneumaticsControl.getStatus()) {
			Robot.pneumaticsControl.release();
		}
		else {
			Robot.pneumaticsControl.keep();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
