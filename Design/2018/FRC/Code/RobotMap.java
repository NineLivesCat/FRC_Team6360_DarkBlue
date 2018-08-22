/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Channel
	public static final int leftFront_MotorChannel = 3;
	public static final int leftRear_MotorChannel = 2;
	public static final int rightFront_MotorChannel = 0;
	public static final int rightRear_MotorChannel = 1;
	
	public static final int elevator_Motor1Channel = 6;
	public static final int elevator_Motor2Channel = 7;
	public static final int gripper_Motor3Channel = 4;
	public static final int gripper_Motor4Channel = 5;
	
	public static final int Lock_Motor5Channel = 8;
	
	public static final int Servo1Channel = 9;
	public static final int Servo2Channel = 10;
	
	public static final int leftJoystick = 1;
	public static final int rightJoystick = 0;
	
	public static final int Solenoid1Channel = 0;
	public static final int Spark1_Channel = 8;
	//Speed 
	public final static double kCollisionThreshold_DeltaG = 0.5f;
	
	public final static double kTime_Lowplace = 0.65;
	public final static double kTime_Highplace = 1.6;
	
	public final static double auto_Speed = 0.6;
	
	public final static double LockMotor_Speed = 0.5;
	
	public final static double GripperMotor_Speed = 0.8;
	public final static double GripperMotorSlow_Speed = 0.2;
	
	public final static double ElevatorControl_Command_Speed = 0.8;
	
	public final static double Drivetrain_SetMaxOutPut_Speed = 0.8;
	
	public final static double kp = 0.03;
	
	
	
	
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
