/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

//import org.usfirst.frc.team6360.robot.OI;
import org.usfirst.frc.team6360.robot.Robot;
//import org.usfirst.frc.team6360.robot.subsystems.Drivetrain;
import org.usfirst.frc.team6360.robot.subsystems.Drivetrain;
//import org.usfirst.frc.team6360.robot.trigger.AxisButton;


public class Drivetrain_arcadeDrive extends Command {
	double threshold = 0.6;
	public Drivetrain_arcadeDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drivetrain);
	} 
 
	// Called just before this Command runs the first time
	@Override
	protected void initialize() { 
		
  	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(Robot.oi.rightJoy.getRawButton(1)) {
		Robot.drivetrain.setArcadeDrive(-Robot.oi.getRightSpeed()*threshold,Robot.oi. getRightX()*threshold);
		}else {
			Robot.drivetrain.setArcadeDrive(-Robot.oi.getRightSpeed(),Robot.oi. getRightX());
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
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
