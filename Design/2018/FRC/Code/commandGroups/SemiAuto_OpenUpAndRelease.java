package org.usfirst.frc.team6360.robot.commandGroups;

import org.usfirst.frc.team6360.robot.Robot;
import org.usfirst.frc.team6360.robot.RobotMap;
import org.usfirst.frc.team6360.robot.commands.ElevatorControl_Command;
import org.usfirst.frc.team6360.robot.commands.Hook_Release;
//import org.usfirst.frc.team6360.robot.commands.Hook_Release2;
import org.usfirst.frc.team6360.robot.commands.PneumaticsControl_Command;
import org.usfirst.frc.team6360.robot.commands.PneumaticsControl_Release;
import org.usfirst.frc.team6360.robot.commands.PneumaticsControl_Command_Auto;
import org.usfirst.frc.team6360.robot.subsystems.Hook;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class SemiAuto_OpenUpAndRelease extends CommandGroup {
	
	public SemiAuto_OpenUpAndRelease() {
		
		addSequential(new Hook_Release());
		addSequential(new PneumaticsControl_Command());
		addSequential(new PneumaticsControl_Release());
	}

}
		
	
			
 