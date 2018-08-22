package org.usfirst.frc.team6360.robot.commands;

import org.usfirst.frc.team6360.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Hook_Catch extends Command {
	Timer timer = new Timer();
	public Hook_Catch() {
		requires(Robot.hook);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {		
		if(timer.get()<0.45) {
		Robot.hook.down();
	    }
		else {
			Robot.hook.stop(); 
		}
		
}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
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
