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
	
	/** PWM Channel*/
	public static final int leftFront_MotorChannel = 0;
	public static final int leftRear_MotorChannel = 1;
	public static final int rightFront_MotorChannel = 2;
	public static final int rightRear_MotorChannel = 3;
	
	public static final int elevator_Motor1Channel = 4;
	public static final int elevator_Motor2Channel = 5;
	
	public static final int gripper_Motor3Channel = 6;
	public static final int lift_Motor4Channel = 7;

	public static final int Servo1Channel = 9;
	public static final int Servo2Channel = 10;
	
	public static final int leftJoystick = 1;
	public static final int rightJoystick = 0;
	
	public static final int Solenoid1Channel = 0;
	public static final int Spark1_Channel = 8;
	
	
	/**Speed*/
	public final static double kCollisionThreshold_DeltaG = 0.5f;
	
	public final static double kTime_Lowplace = 0.65;
	public final static double kTime_Highplace = 1.6;
	
	public final static double auto_Speed = 0.6;
	
	public final static double LockMotor_Speed = 0.5;
	
	public final static double GripperMotor_Speed = 0.8;
	public final static double GripperMotorSlow_Speed = 0.2;
	
	public final static double lift_Speed = 1;
	
	public final static double ElevatorControl1_Command_Speed = 0.8;
	public final static double ElevatorControl2_Command_Speed = -0.5;
	public final static double ElevatorControl2_Max_Command_Speed = -1;
	
	public final static double Drivetrain_SetMaxOutPut_Speed = 0.8;
	
	public final static double kp = 0.03;
	
	
	
	
	/** RobotMessage*/
	public final static String robotIniMessage = "Create Robot instance!";
	
	public final static String drivetrainMessage = "Create Drivetrain Subsystem instance!";
	public final static String elevatorControlMessage = "Create ElevatorControl Subsystem instance!";
	public final static String gripperMessage = "Create Gripper Subsystem instance!";
	
	public final static String AutoDriveMessage = "Go for distance: ";
	public final static String AutoTurningMessage = "Turn angle:  ";
	
	/** AutoKey*/
	public final static double Auto_Elevator_FastUp = 0.8;
	public final static double Auto_Elevator_Stop = 0.5;
	public final static double Auto_Elevator_Time = 3;
	
	/** direction*/
	public final static boolean positive = false;
}
