package org.usfirst.frc.team6360.robot.subsystems;

import org.usfirst.frc.team6360.robot.Robot;
import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.Hook_Catch;
import org.usfirst.frc.team6360.robot.commands.Hook_Release;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Hook  extends Subsystem {
	Spark spark = new Spark(RobotMap.Spark1_Channel);
	private DigitalInput mircoSwithch = new DigitalInput(7); 
	public void down() {
		spark.set(0.6);
	}
	public void up() {
		spark.set(-0.6);
	} 
	public void stop() {
		spark.set(0);
	}
	
	protected void initDefaultCommand() {
	}
	public boolean getMircoSwithch() {
		return mircoSwithch.get();
	}
	public void setMircoSwithch(DigitalInput mircoSwithch) {
		this.mircoSwithch = mircoSwithch;
	}
}
