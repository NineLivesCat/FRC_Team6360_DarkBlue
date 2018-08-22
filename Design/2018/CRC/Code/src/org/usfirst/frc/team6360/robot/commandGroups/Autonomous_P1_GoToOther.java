package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.Auto_ElevatorControl_command;
import org.usfirst.frc.team6360.robot.commands.Gripper_down;
import org.usfirst.frc.team6360.robot.commands.Gripper_release;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_P1_GoToOther extends CommandGroup{
	public Autonomous_P1_GoToOther () {
		if (RobotMap.positive) {
			addSequential(new Auto_Drivetrain_ArcadeDrive(2),3);
			addSequential(new Auto_Drivetrain_Turing(-45));
		}
		else {
			addSequential(new Auto_Drivetrain_ArcadeDrive(-2),3);
			addSequential(new Auto_Drivetrain_Turing(135));
		}
		addSequential(new Auto_Drivetrain_ArcadeDrive(1),2);
		addSequential(new Auto_Drivetrain_Turing(45));
		addSequential(new Auto_Drivetrain_ArcadeDrive(1),2);
		addSequential(new Auto_Drivetrain_Turing(90));
		addSequential(new Auto_Drivetrain_ArcadeDrive(4),5);
		addSequential(new Auto_Drivetrain_Turing(90));
		addSequential(new Auto_ElevatorControl_command());
		addSequential(new Gripper_down(),2);
		addSequential(new Gripper_release(),2);
	//addSequential(new Auto_Drivetrain_ArcadeDrive(-4),4);
//	addSequential(new Auto_Drivetrain_ArcadeDrive(-3));

	
	
	//addSequential(new Auto_Drivetrain_ArcadeDrive(0.3));
	}
} 
