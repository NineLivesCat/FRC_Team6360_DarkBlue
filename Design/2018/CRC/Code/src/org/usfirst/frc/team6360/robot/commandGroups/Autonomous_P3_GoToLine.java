package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.Auto_ElevatorControl_command;
import org.usfirst.frc.team6360.robot.commands.Gripper_down;
import org.usfirst.frc.team6360.robot.commands.Gripper_release;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_P3_GoToLine extends CommandGroup{
	public Autonomous_P3_GoToLine () {
		if (RobotMap.positive) {
			addSequential(new Auto_Drivetrain_ArcadeDrive(4),5);
		}
		else {
			addSequential(new Auto_Drivetrain_ArcadeDrive(-2),3);
			addSequential(new Auto_Drivetrain_Turing(180));
			addSequential(new Auto_Drivetrain_ArcadeDrive(2),2);
		}
		
		addSequential(new Auto_ElevatorControl_command());
		addSequential(new Gripper_down(),2);
		addSequential(new Gripper_release(),2);
	//addSequential(new Auto_Drivetrain_ArcadeDrive(0.3));
	}
} 
