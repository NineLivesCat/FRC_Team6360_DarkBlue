package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_Turing;
import org.usfirst.frc.team6360.robot.commands.ElevatorControl_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;
 
public class Autonomous_GoSide_Position3_OtherSide extends CommandGroup {
	public Autonomous_GoSide_Position3_OtherSide() {
		addSequential(new Auto_Drivetrain_ArcadeDrive(-0.5));
        addSequential(new Auto_Drivetrain_Turing(-95));
        addSequential(new Auto_Drivetrain_ArcadeDrive(-2.2));
        addSequential(new Auto_Drivetrain_Turing(15));
        addSequential(new Auto_Drivetrain_ArcadeDrive(-3.3));
        
        
        
//        addSequential(new Auto_Drivetrain_Turing(80));
//        addSequential(new Auto_Drivetrain_ArcadeDrive(-3,0,false));
//        addSequential(new Auto_Drivetrain_Turing(80));
//    	addSequential(new Auto_Drivetrain_ArcadeDrive(-0.5,0,false));
	}
} 
