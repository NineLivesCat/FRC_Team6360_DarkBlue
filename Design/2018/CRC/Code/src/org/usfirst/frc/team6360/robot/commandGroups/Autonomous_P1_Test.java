package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.Auto_ElevatorControl_command;
import org.usfirst.frc.team6360.robot.commands.Gripper_down;
import org.usfirst.frc.team6360.robot.commands.Gripper_release;
import org.usfirst.frc.team6360.robot.commands.Gripper_up;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_P1_Test extends CommandGroup{
	public Autonomous_P1_Test () {
	//addSequential(new Auto_Drivetrain_ArcadeDrive(-4),4);
//	addSequential(new Auto_Drivetrain_ArcadeDrive(-3));
	addSequential(new Auto_Drivetrain_ArcadeDrive(-4),6);
	addSequential(new Auto_Drivetrain_Turing(45),1);
	addParallel(new Gripper_up());
	//addSequential(new Auto_Drivetrain_ArcadeDrive(0.3));
	}
} 
