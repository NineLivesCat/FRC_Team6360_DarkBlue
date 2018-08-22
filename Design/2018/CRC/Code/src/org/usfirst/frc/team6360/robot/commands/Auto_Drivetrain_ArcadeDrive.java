/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.commands;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import sun.net.www.content.text.plain;

import javax.print.attribute.standard.PrinterLocation;

//import org.usfirst.frc.team6360.robot.OI;
import org.usfirst.frc.team6360.robot.Robot;
//import org.usfirst.frc.team6360.robot.subsystems.Drivetrain;
import org.usfirst.frc.team6360.robot.RobotMap;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;


public class Auto_Drivetrain_ArcadeDrive extends Command {
	double distance;
	double speed;
	double error;
	double message;
	public Auto_Drivetrain_ArcadeDrive (double distance) {
		requires(Robot.drivetrain);
		this.distance = distance;
		if(distance>0) {
			speed=0.6;
		}else { 
			speed=-0.6;
		}
	}

	protected void initialize() {
		//Robot.navx.getAhrs().reset();
		Robot.drivetrain.getGyro().reset();
		Robot.drivetrain.getLeftEncoder().reset();	
		//Robot.navx.getUltrasonic().resetAccumulator();
		Robot.drivetrain.getLeftEncoder().setDistancePerPulse(1.0/360);
		//Robot.drivetrain.getRightEncoder().setDistancePerPulse(1.0/360);
		System.out.println(RobotMap.AutoDriveMessage + this.distance);
	}

	protected void execute() {
		error = Math.abs(distance)*2 - Math.abs(getAverageEncoderPosition());
		Robot.drivetrain.setArcadeDrive(speed,-Robot.drivetrain.getGyro().getAngle()*0.03);
		message = getAverageEncoderPosition();
		System.out.println(message);
	}
	private double getAverageEncoderPosition() {
	    return Robot.drivetrain.getLeftEncoder().getDistance();
	}
	@Override
	protected void end() {
		Robot.drivetrain.setArcadeDrive(0, 0);
	}
	@Override
	protected boolean isFinished() {
		if(error>-0.1&&error<0.1) {
		return true;
		}
		return false;
	}
}