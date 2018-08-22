/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import javax.imageio.ImageTypeSpecifier;

import org.usfirst.frc.team6360.robot.commandGroups.SemiAuto_OpenUpAndRelease;

import org.usfirst.frc.team6360.robot.commands.*;
import org.usfirst.frc.team6360.robot.trigger.AxisButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick leftJoy = new Joystick(RobotMap.leftJoystick);
	private Joystick rightJoy = new Joystick(RobotMap.rightJoystick);
	public OI() {
		Button leftButton1 = new JoystickButton(leftJoy, 1),
		leftButton2 = new JoystickButton(leftJoy, 2),
		leftButton3 = new JoystickButton(leftJoy, 3),
		leftButton4 = new JoystickButton(leftJoy, 4),
		//leftButton5 = new JoystickButton(leftJoy, 5),
		leftButton6 = new JoystickButton(leftJoy, 6),
		//leftButton7 = new JoystickButton(leftJoy, 7),
		leftButton8 = new JoystickButton(leftJoy, 8);
		//leftButton9 = new JoystickButton(leftJoy, 9),
		//leftButton10 = new JoystickButton(leftJoy, 10);
	
		//rightButton2 = new JoystickButton(rightJoy, 2),
		//rightButton3 = new JoystickButton(rightJoy, 3),
		//rightButton4 = new JoystickButton(rightJoy, 4);
	
		Button AxisButton = new AxisButton(leftJoy, 2,0.1,0);
		Button AxisButton2 = new AxisButton(leftJoy, 3,0.1,0);
		//Button AxisButton3 = new AxisButton(rightJoy, 3,0,0);
	
		//leftButton2.whileHeld(new Drivetrain_TankDrive())
		leftButton4.whenPressed(new ElevatorControl_Command(RobotMap.ElevatorControl_Command_Speed));
		leftButton4.whenReleased(new ElevatorControl_Command(0));
		leftButton1.whenPressed(new ElevatorControl_Command(-RobotMap.ElevatorControl_Command_Speed));
		leftButton1.whenReleased(new ElevatorControl_Command(0));
		leftButton2.whileHeld(new Gripper_Grab());
		leftButton3.whileHeld(new Gripper_Release());
		//leftButton5.whileHeld(new Gripper_Release2());
		leftButton6.whenPressed(new PneumaticsControl_Command());
		leftButton6.whenReleased(new PneumaticsControl_Release());
		//leftButton7. whileHeld(new Hook_Release());	
		//leftButton8. whenPressed( new Hook_Catch());
	    leftButton8.whenPressed(new SemiAuto_OpenUpAndRelease());
 	    AxisButton.whenPressed(new Hook_Catch());
 	    AxisButton2.whileHeld(new Hook_Release()); 	  
 	    //AxisButton3.whileHeld(new Drivetrain_ArcadeDrive());
		}
	    public double getRightY() {
	    	return getRightJoy().getY();
	    }    
	    public double getRightX() {
	    	return getRightJoy().getX();
	    }
	    public double getLeftSilder() {
	    	return leftJoy.getRawAxis(3);
	    }
		public Joystick getRightJoy() {
			return rightJoy;
		}
		public void setRightJoy(Joystick rightJoy) {
			this.rightJoy = rightJoy;
		}
}
