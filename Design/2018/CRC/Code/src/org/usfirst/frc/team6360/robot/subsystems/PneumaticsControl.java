/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot.subsystems;



import org.usfirst.frc.team6360.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticsControl extends Subsystem {
	
	Compressor com1 = new Compressor();
	private Solenoid sol1 = new Solenoid(RobotMap.Solenoid1Channel);
	
	public void keep() {
		getSol1().set(true);
	}
	
	public void release() {
		getSol1().set(false);
	}
	
	public boolean getStatus() {
		return getSol1().get();
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		//  Set the default command for a subsystem here.
//		setDefaultCommand(new IsTankDrive());

	}

	public Solenoid getSol1() {
		return sol1;
	}

	public void setSol1(Solenoid sol1) {
		this.sol1 = sol1;
	}
}
