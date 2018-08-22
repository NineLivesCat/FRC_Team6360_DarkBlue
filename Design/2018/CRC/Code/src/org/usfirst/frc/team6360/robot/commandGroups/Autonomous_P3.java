package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.Auto_ElevatorControl_command;
import org.usfirst.frc.team6360.robot.commands.Gripper_down;
import org.usfirst.frc.team6360.robot.commands.Gripper_release;
import org.usfirst.frc.team6360.robot.commands.PneumaticsControl_Command_Auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_P3 extends CommandGroup{
	public Autonomous_P3 () {
		
		
		String autoSelect = null;
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		  if(gameData.charAt(0) == 'L')
		  {		autoSelect = "My Auto1";
		  } else if(gameData.charAt(0) == 'R'){
				autoSelect = "My Auto2";
		  }
		switch (autoSelect) {
	case "My Auto1":
		
		if (RobotMap.positive) {
			addSequential(new Auto_Drivetrain_ArcadeDrive(4),5);
		}
		else {
			addSequential(new Auto_Drivetrain_ArcadeDrive(-5),6);
			addSequential(new Auto_Drivetrain_Turing(90));
			addSequential(new Auto_Drivetrain_ArcadeDrive(4),5);
			addSequential(new Auto_Drivetrain_Turing(-90));
			addSequential(new Auto_ElevatorControl_command());
			addSequential(new Gripper_down(),2);
			addSequential(new PneumaticsControl_Command_Auto());
		}
		
//		if (RobotMap.positive) {
//			addSequential(new Auto_Drivetrain_ArcadeDrive(4),5);
//		}
//		else {
//			addSequential(new Auto_Drivetrain_ArcadeDrive(-2),3);
//			addSequential(new Auto_Drivetrain_Turing(180));
//			addSequential(new Auto_Drivetrain_ArcadeDrive(2),2);
//		}
//		
//		addSequential(new Auto_ElevatorControl_command());
//		addSequential(new Gripper_down(),2);
//		addSequential(new Gripper_release(),2);
		
		break;
	case "My Auto2":
		
		if (RobotMap.positive) {
			addSequential(new Auto_Drivetrain_ArcadeDrive(4),5);
		}
		else {
			addSequential(new Auto_Drivetrain_ArcadeDrive(-4),5);
		}
		
		addSequential(new Auto_ElevatorControl_command());
		addSequential(new Gripper_down(),2);
		addSequential(new PneumaticsControl_Command_Auto());
		
//		if (RobotMap.positive) {
//			addSequential(new Auto_Drivetrain_ArcadeDrive(2),3);
//			addSequential(new Auto_Drivetrain_Turing(-45));
//		}
//		else {
//			addSequential(new Auto_Drivetrain_ArcadeDrive(-2),3);
//			addSequential(new Auto_Drivetrain_Turing(135));
//		}
//		addSequential(new Auto_Drivetrain_ArcadeDrive(1),2);
//		addSequential(new Auto_Drivetrain_Turing(45));
//		addSequential(new Auto_Drivetrain_ArcadeDrive(1),2);
//		addSequential(new Auto_Drivetrain_Turing(90));
//		addSequential(new Auto_Drivetrain_ArcadeDrive(4),5);
//		addSequential(new Auto_Drivetrain_Turing(90));
//		addSequential(new Auto_ElevatorControl_command());
//		addSequential(new Gripper_down(),2);
//		addSequential(new Gripper_release(),2);
//		
		break;
	default:
		break;
		
	//addSequential(new Auto_Drivetrain_ArcadeDrive(0.3));
	}
		
		
		
	//addSequential(new Auto_Drivetrain_ArcadeDrive(0.3));
	}
} 
