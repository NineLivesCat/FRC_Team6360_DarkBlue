package org.usfirst.frc.team6360.robot.commands;

import org.usfirst.frc.team6360.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Auto_Drivetrain_Turing extends Command{
	double angle;
	public Auto_Drivetrain_Turing(int angle) {
		//this.angle = (angle*3.14)/180*2; 
		this.angle = angle;
	}
	protected void  initialize() {
		Robot.drivetrain.getGyro().reset();
	}
	double error;
	double previous_error;
	double integral;
	double derivative;
	double kP = 0.015;
	double kI = 0.0005;
	double kD = 0;
	double integral_threshold = 0.4;
		public double outPutValue(double target){
			previous_error = error;
			
			error = target - Robot.drivetrain.getGyro().getAngle();
			
			if(Math.abs(error*kP)< integral_threshold){
					integral += error;
			}else{
				integral = 0;
			}

			derivative = error - previous_error;
			
			return kP*error + kI*integral +kD*derivative;
		}
		
	protected void execute() {
		System.out.println("Turning angle: " + Robot.drivetrain.getGyro().getAngle());
//		System.out.println(error*kP);
//		System.out.println(integral*kP);
		//System.out.println(derivative);

		Robot.drivetrain.setArcadeDrive(0, outPutValue(angle));
	}
	@Override
	protected void end() {
		Robot.drivetrain.setArcadeDrive(0, 0);
	}    
	@Override 
	protected boolean isFinished() {
		if((Robot.drivetrain.getGyro().getAngle()>(angle-0.5))&&(Robot.drivetrain.getGyro().getAngle()<(angle+0.5))) {
			return true;
		}
		return false;
	}
}