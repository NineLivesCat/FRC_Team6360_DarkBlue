package org.usfirst.frc.team6360.robot.commandGroups;

import javax.xml.transform.Templates;

import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.ElevatorControl_Command;
import org.usfirst.frc.team6360.robot.commands.Gripper_Grab;
import org.usfirst.frc.team6360.robot.commands.Gripper_Release;
import org.usfirst.frc.team6360.robot.commands.PneumaticsControl_Command_Auto;

import com.sun.org.apache.bcel.internal.generic.NEW;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_GoMiddle_Left extends CommandGroup{
	public Autonomous_GoMiddle_Left () {
	//addSequential(new Auto_Drivetrain_ArcadeDrive(-4),4);
	//addSequential(new Auto_Drivetrain_ArcadeDrive(-3));
	addSequential(new Auto_Drivetrain_Turing(45));
	//addSequential(new Auto_Drivetrain_ArcadeDrive(0.3));
	}
} 
