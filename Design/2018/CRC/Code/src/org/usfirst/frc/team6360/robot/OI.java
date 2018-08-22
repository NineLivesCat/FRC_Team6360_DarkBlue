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

//import org.usfirst.frc.team6360.robot.commandGroups.SemiAuto_OpenUpAndRelease;

import org.usfirst.frc.team6360.robot.commands.*;
//import org.usfirst.frc.team6360.robot.trigger.AxisButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick leftJoy = new Joystick(RobotMap.leftJoystick);
	public Joystick rightJoy = new Joystick(RobotMap.rightJoystick);
	public OI() {
	Button leftButton1 = new JoystickButton(leftJoy, 1),
	leftButton2 = new JoystickButton(leftJoy, 2),
	leftButton3 = new JoystickButton(leftJoy, 3),
	leftButton4 = new JoystickButton(leftJoy, 4),
	leftButton5 = new JoystickButton(leftJoy, 5),
	leftButton6 = new JoystickButton(leftJoy, 6),
	leftButton7 = new JoystickButton(leftJoy, 7),
	leftButton8 = new JoystickButton(leftJoy, 8);
	//leftButton9 = new JoystickButton(leftJoy, 9),
	//leftButton10 = new JoystickButton(leftJoy, 10);
	
	
	//Button rightButton1 = new JoystickButton(rightJoy, 1),
	//rightButton2 = new JoystickButton(rightJoy, 2),
	//rightButton3 = new JoystickButton(rightJoy, 3),
	//rightButton4 = new JoystickButton(rightJoy, 4);
//	
//	Button AxisButton = new AxisButton(leftJoy, 2,0.1,0);
//	Button AxisButton2 = new AxisButton(leftJoy, 3,0.1,0);
//	Button AxisButton3 = new AxisButton(rightJoy, 3,0,0);
	
//		leftButton2.whileHeld(new Drivetrain_TankDrive())
//		leftButton4.whenPressed(new ElevatorControl_Command(RobotMap.ElevatorControl_Command_Speed));
//		leftButton4.whenReleased(new ElevatorControl_Command(0));
//		leftButton7.whenPressed(new ElevatorControl_Command(-RobotMap.ElevatorControl_Command_Speed));
//		leftButton1.whenReleased(new ElevatorControl_Command(0));
//		leftButton3.whileHeld(new Gripper_grab());
//		leftButton4.whileHeld(new Gripper_release());
		leftButton5.whileHeld(new Gripper_up());
		leftButton6.whileHeld(new Gripper_down());
		leftButton1.whileHeld(new ElevatorControl_command(RobotMap.ElevatorControl1_Command_Speed));
		leftButton2.whileHeld(new ElevatorControl_command(RobotMap.ElevatorControl2_Command_Speed));
		leftButton8.whileHeld(new ElevatorControl_command(RobotMap.ElevatorControl2_Max_Command_Speed));
//		leftButton5.whileHeld(new Gripper_Release2());
		leftButton7.whenPressed(new PneumaticsControl_Command());
		leftButton7.whenReleased(new PneumaticsControl_Release());
//		leftButton7. whileHeld(new Hook_Release());
//	    leftButton8. whenPressed( new Hook_Catch());
//	    leftButton8.whenPressed(new SemiAuto_OpenUpAndRelease());
// 	    AxisButton.whenPressed(new Hook_Catch());
// 	    AxisButton2.whileHeld(new Hook_Release()); 	  
 	  //  AxisButton3.whileHeld(new Drivetrain_ArcadeDrive());
	}
	    public double getRightSpeed() {
	    	return rightJoy.getY();
	    }    
	    public double getRightX() {
	    	return rightJoy.getX();
	    }
	    public double getLeftSilder() {
	    	return leftJoy.getRawAxis(3);
	    }
//	    public boolean getRawAxis2Press() {
//	    	return leftJoy.getRawAxis(2)!=0;
//	    }	    
//	    public boolean getRawAxis3Press() {
//	    	return leftJoy.getRawAxis(3)!=0;
//	    }
}
	
	
	 
//		leftButton7.whenPressed(new ElevatorControl_Command(1,RobotMap.kTime_Lowplace));
		
	/**
	 *public double getLeftSpeed() {
		return leftJoy.getY(); 
	}
	public double getRightSpeed() {
		return rightJoy.getY();
	}
	
	public double getRightX() {
		return rightJoy.getX();
	}
	
	public double getLeftRotation() {
		return leftJoy.getZ();
	}
	public double getRightRotation() {
		return rightJoy.getZ();
	} 
	 * @return
	 */
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());


/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//package org.usfirst.frc.team6360.robot;
//
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import org.usfirst.frc.team6360.robot.commands.*;
//
///**
// * This class is the glue that binds the controls on the physical operator
// * interface to the commands and command groups that allow control of the robot.
// */
//public class OI {
//	
//	// test
//	
//	Joystick leftJoy = new Joystick(RobotMap.leftJoystick);
//	Joystick rightJoy = new Joystick(RobotMap.rightJoystick);
//	
//	Button leftButton1 = new JoystickButton(leftJoy, 1),
//	leftButton2 = new JoystickButton(leftJoy, 2),
//	leftButton3 = new JoystickButton(leftJoy, 3),
//	leftButton4 = new JoystickButton(leftJoy, 4);
//	
//	Button rightButton1 = new JoystickButton(rightJoy, 1),
//	rightButton2 = new JoystickButton(rightJoy, 2),
//	rightButton3 = new JoystickButton(rightJoy, 3),
//	rightButton4 = new JoystickButton(rightJoy, 4);
//	
//	
//	public OI() {
//		
//		leftButton2.whileHeld(new IsArcadeDrive());
//		leftButton3.whileHeld(new LiftUpAndDown(1));
//		leftButton4.whileHeld(new LiftUpAndDown(-1));
//	}
//	
//	public double getLeftSpeed() {
//		return leftJoy.getY();
//	}
//	public double getRightSpeed() {
//		return rightJoy.getY();
//	}
//	
//	public double getLeftRotation() {
//		return leftJoy.getZ();
//	}
//	public double getRightRotation() {
//		return rightJoy.getZ();
//	}
//	//// CREATING BUTTONS
//	// One type of button is a joystick button which is any button on a
//	//// joystick.
//	// You create one by telling it which joystick it's on and which button
//	// number it is.
//	// Joystick stick = new Joystick(port);
//	// Button button = new JoystickButton(stick, buttonNumber);
//
//	// There are a few additional built in buttons you can use. Additionally,
//	// by subclassing Button you can create custom triggers and bind those to
//	// commands the same as any other Button.
//
//	//// TRIGGERING COMMANDS WITH BUTTONS
//	// Once you have a button, it's trivial to bind it to a button in one of
//	// three ways:
//
//	// Start the command when the button is pressed and let it run the command
//	// until it is finished as determined by it's isFinished method.
//	// button.whenPressed(new ExampleCommand());
//
//	// Run the command while the button is being held down and interrupt it once
//	// the button is released.
//	// button.whileHeld(new ExampleCommand());
//
//	// Start the command when the button is released and let it run the command
//	// until it is finished as determined by it's isFinished method.
//	// button.whenReleased(new ExampleCommand());
//}
