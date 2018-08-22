/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

//import org.usfirst.frc.team6360.robot.OI;
import org.usfirst.frc.team6360.robot.Robot;
//import org.usfirst.frc.team6360.robot.subsystems.Drivetrain;
import org.usfirst.frc.team6360.robot.RobotMap;


public class Auto_ElevatorControl_command extends Command {
	
	double Speed;
	double Auto_PlateTime;
	Timer time = new Timer();
	
	public Auto_ElevatorControl_command() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevatorControl);
	}
	
//	public LiftUpAndDown(double speed1, double speed2) {
//		// Use requires() here to declare subsystem dependencies
//		requires(Robot.elevatorControl);
//		Speed1 = speed1;
//		Speed2 = speed2;
//		
//	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		time.reset();
		time.start();
		Robot.elevatorControl.Vict1Speed(RobotMap.Auto_Elevator_FastUp);
		Robot.elevatorControl.Vict2Speed(RobotMap.Auto_Elevator_FastUp);

//			Robot.elevatorControl.Vict1Speed(Speed1);
//			Robot.elevatorControl.Vict2Speed(Speed2);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//System.out.println(time.get());
//		if(Speed>0) {
//		if(!Robot.elevatorControl.digitalInput.get()) {
//		Robot.elevatorControl.Vict1Speed(0);
//		Robot.elevatorControl.Vict2Speed(0);
//		}
//		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(time.get() >= RobotMap.Auto_Elevator_Time) {
			return true;
		}
			return false;
		
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.elevatorControl.auto_stop();
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
