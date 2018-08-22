package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.ElevatorControl_Command;

import com.sun.glass.ui.CommonDialogs;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous_GoSide_Position1_OtherSide extends CommandGroup {
	public Autonomous_GoSide_Position1_OtherSide() {		
		addSequential(new Auto_Drivetrain_ArcadeDrive(-0.5));
        addSequential(new Auto_Drivetrain_Turing(80));
        addSequential(new Auto_Drivetrain_ArcadeDrive(-1.8));
        addSequential(new Auto_Drivetrain_Turing(-15));
        addSequential(new Auto_Drivetrain_ArcadeDrive(-3));
        addSequential(new Auto_Drivetrain_Turing(-90));
        addSequential(new Auto_Drivetrain_ArcadeDrive(-2));
	}
}
