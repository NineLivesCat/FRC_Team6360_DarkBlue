/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.subsystems;



import org.usfirst.frc.team6360.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorControl extends Subsystem {
	
	VictorSP Vict1 = new VictorSP(RobotMap.elevator_Motor1Channel);
	VictorSP Vict2 = new VictorSP(RobotMap.elevator_Motor2Channel);
	private DigitalInput digitalInput = new DigitalInput(1); 
	public void Vict1Speed(double speed) {
		Vict1.set(speed);
	}
	
	public void Vict2Speed(double speed) {
		Vict2.set(speed);
	}
	
	public void stop() {
		Vict1.stopMotor();
		Vict2.stopMotor();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new IsTankDrive());

	}

	public DigitalInput getDigitalInput() {
		return digitalInput;
	}

	public void setDigitalInput(DigitalInput digitalInput) {
		this.digitalInput = digitalInput;
	}
}
