package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.ElevatorControl_Command;
import org.usfirst.frc.team6360.robot.commands.Gripper_Grab;
import org.usfirst.frc.team6360.robot.commands.PneumaticsControl_Command_Auto;
public class Autonomous_Goside_Position1  extends CommandGroup{
	public Autonomous_Goside_Position1(){
		addSequential(new Auto_Drivetrain_ArcadeDrive(-4),5);
		addSequential(new ElevatorControl_Command(0.5), 2);
		addSequential(new ElevatorControl_Command(-0.5), 2);
//		addSequential(new Auto_Drivetrain_ArcadeDrive(0.4,0,true));
//		addSequential(new Auto_Drivetrain_Turing(-45));
//	 	addSequential(new Gripper_Grab(true), 5);
//		addSequential(new Auto_Drivetrain_ArcadeDrive(0.8,45,false));
//		addSequential(new Auto_Drivetrain_ArcadeDrive(-0.3,0));
//		addSequential(new Auto_Drivetrain_ArcadeDrive(0.3,0));
	}
}
