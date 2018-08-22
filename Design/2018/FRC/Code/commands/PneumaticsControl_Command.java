/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import java.util.concurrent.Delayed;

//import org.usfirst.frc.team6360.robot.OI;
import org.usfirst.frc.team6360.robot.Robot;
import org.usfirst.frc.team6360.robot.subsystems.PneumaticsControl;


public class PneumaticsControl_Command extends Command {
	
	
	public PneumaticsControl_Command() {
		requires(Robot.pneumaticsControl);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.pneumaticsControl.keep();
		end();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		end();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(Robot.pneumaticsControl.getSol1().get()) {
			Timer.delay(0.5);
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
