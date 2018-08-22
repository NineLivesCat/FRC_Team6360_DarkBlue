package org.usfirst.frc.team6360.robot.commands;

import org.usfirst.frc.team6360.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.command.Command;

public class Hook_Release extends Command{

	 public Hook_Release() {
		requires(Robot.hook);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	    Robot.hook.up();
		}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(!Robot.hook.getMircoSwithch()) {
			return true;
			} 
		return false;			
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.hook.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
