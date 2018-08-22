package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.ElevatorControl_Command;
import org.usfirst.frc.team6360.robot.commands.Gripper_Grab;
import org.usfirst.frc.team6360.robot.commands.Gripper_Release;
import org.usfirst.frc.team6360.robot.commands.PneumaticsControl_Command_Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_GoSide_Position3 extends CommandGroup {
	public Autonomous_GoSide_Position3 () {
		addSequential(new Auto_Drivetrain_ArcadeDrive(-3),4);
		addSequential(new ElevatorControl_Command(0.5), 2);
		addSequential(new ElevatorControl_Command(-0.5), 2);
		addSequential(new Auto_Drivetrain_ArcadeDrive(1.5),2);
		addSequential(new Auto_Drivetrain_Turing(-45));
		addSequential(new Auto_Drivetrain_ArcadeDrive(-0.7));
		addSequential(new Auto_Drivetrain_Turing(40));
	    addSequential(new Auto_Drivetrain_ArcadeDrive(-2));
	}
}
