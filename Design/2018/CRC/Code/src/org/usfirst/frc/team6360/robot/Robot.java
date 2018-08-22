/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6360.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.ietf.jgss.Oid;
import org.opencv.features2d.Feature2D;
import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_P1;
import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_P1_GoToLine;
import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_P1_GoToOther;
import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_P1_Test;
import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_P2;
import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_P3;
//import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_GoMiddle_Left;
//import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_GoMiddle_Right;
//import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_GoSide_Position1_OtherSide;
//import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_GoSide_Position3;
//import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_GoSide_Position3_OtherSide;
//import org.usfirst.frc.team6360.robot.commandGroups.Autonomous_Goside_Position1;
//import org.usfirst.frc.team6360.robot.commands.Auto_Drivetrain_ArcadeDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6360.robot.subsystems.Drivetrain;
import org.usfirst.frc.team6360.robot.subsystems.ElevatorControl;

import org.usfirst.frc.team6360.robot.subsystems.Gripper;
import org.usfirst.frc.team6360.robot.subsystems.PneumaticsControl;
//import org.usfirst.frc.team6360.robot.subsystems.NavX;
//import org.usfirst.frc.team6360.robot.subsystems.PneumaticsControl;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {	
//	public static final ExampleSubsystem kExampleSubsystem
//			= new ExampleSubsystem();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final ElevatorControl elevatorControl = new ElevatorControl();
	//public static final VisionProcess visionProcess = new VisionProcess();
	public static final Gripper gripper = new Gripper();
	public static final PneumaticsControl pneumaticsControl = new PneumaticsControl();
	//public static final FieldControl FIELD_CONTROL = new FieldControl();
	public static OI oi;
//	public static NavX  navx = new NavX();
	Command m_autonomousCommand;
	SendableChooser sc = new SendableChooser();
	Thread visionThread;
//	SendableChooser<Command> m_chooser = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		sc.addDefault("TEST", 0);
		sc.addObject("P1", 1);
		sc.addObject("P2", 2);
		sc.addObject("P3", 3);
		SmartDashboard.putData("Auto", sc);
		System.out.println(RobotMap.robotIniMessage);
////		visionThread = new Thread(() -> {
////			// Get the UsbCamera from CameraServer
////			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(1);
////			UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(0);
////			camera.setResolution(640, 480);
////			camera2.setResolution(640, 480);
////		});
////		visionThread.start();
//	}
//	//new VisionProcess_StartCV().start();
		Scheduler.getInstance().run();
	}
////		 
////		new CameraCapture().start();
////		new CameraCapture();
//
////		m_chooser.addDefault("Default Auto", new ExampleCommand());
//		// chooser.addObject("My Auto", new MyAutoCommand());
////		SmartDashboard.putData("Auto mode", m_chooser);
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
    public void disabledInit() {
	 }
	 public void robotPeriodic() {	 
	 } 
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */ 
	@Override
	public void autonomousInit() {
		Robot.drivetrain.getLeftEncoder().reset();
		
		System.out.println(sc.getSelected());
		
		if((int) sc.getSelected() ==1) {
		m_autonomousCommand = new Autonomous_P1();
	}
		else if((int) sc.getSelected() ==2) {
		m_autonomousCommand = new Autonomous_P2();
	}
		else if((int) sc.getSelected() ==3) {
		m_autonomousCommand = new Autonomous_P3();
	}
		else {
		m_autonomousCommand = new Autonomous_P1_Test();
	}
		
//
//	String autoSelect = null;
//	String gameData = DriverStation.getInstance().getGameSpecificMessage();
//		  if(gameData.charAt(0) == 'L')
//		  {		autoSelect = "My Auto1";
//		  } else if(gameData.charAt(0) == 'R'){
//				autoSelect = "My Auto2";
//		  }
//		switch (autoSelect) {
//	case "My Auto1":
//		if((int) sc.getSelected() ==1) {
//			m_autonomousCommand = new Autonomous_P1();
//		}
//		else if((int) sc.getSelected() ==2) {
//			m_autonomousCommand = new Autonomous_P2();
//		}
//		else if((int) sc.getSelected() ==3) {
//			m_autonomousCommand = new Autonomous_P3();
//		}
//		else {
//			m_autonomousCommand = new Autonomous_P1_Test();
//		}
//		m_autonomousCommand = new Autonomous_P1_Test();
	//	m_autonomousCommand = new Autonomous_Goside_Position1();
//		//m_autonomousCommand = new Autonomous_GoSide_Position3_OtherSide();
//		break;
//	case "My Auto2":
//		m_autonomousCommand = new Autonomous_P1_Test();
////		m_autonomousCommand = new Autonomous_P1_GoToOther();
//		//m_autonomousCommand = new Autonomous_Goside_Position1();
//		//m_autonomousCommand = new Autonomous_GoSide_Position3_OtherSide();
//		break;
//	default:
//		break;
//		}
//		
		
		if (m_autonomousCommand != null) {
		m_autonomousCommand.start();
	}
		
		
//		Robot.drivetrain.getLeftEncoder().reset();
//			String autoSelect = null;
//			String gameData;
//			gameData = DriverStation.getInstance().getGameSpecificMessage();
//				  if(gameData.charAt(0) == 'L'&&gameData.charAt(1) == 'L')
//				  {		autoSelect = "My Auto1";
//					//Put left auto code here
//				  } else if(gameData.charAt(0) == 'L'&&gameData.charAt(1) == 'R'){
//						autoSelect = "My Auto2";
//				  }else if(gameData.charAt(0) == 'R'&&gameData.charAt(1) == 'R') {
//						autoSelect = "My Auto3";
//				  }else if(gameData.charAt(0) == 'R'&&gameData.charAt(1) == 'L') {
//						autoSelect = "My Auto4";
//				  }
//	   		switch (autoSelect) {
//			case "My Auto1":
//				m_autonomousCommand = new Autonomous_GoMiddle_Left();
//			//	m_autonomousCommand = new Autonomous_Goside_Position1();
//				//m_autonomousCommand = new Autonomous_GoSide_Position3_OtherSide();
//				break;
//			case "My Auto2":
//				m_autonomousCommand = new Autonomous_GoMiddle_Left();
//				//m_autonomousCommand = new Autonomous_Goside_Position1();
//				//m_autonomousCommand = new Autonomous_GoSide_Position3_OtherSide();
//				break;
//			case "My Auto3":
//				m_autonomousCommand = new Autonomous_GoMiddle_Right(); 
//				//m_autonomousCommand = new Autonomous_GoSide_Position1_OtherSide();
//				//m_autonomousCommand = new Autonomous_GoSide_Position3();
//				break;
//			case "My Auto4":
//				m_autonomousCommand = new Autonomous_GoMiddle_Right();
//				//m_autonomousCommand = new Autonomous_GoSide_Position1_OtherSide();
//				//m_autonomousCommand = new Autonomous_GoSide_Position3();
//				break;
//			default:
//				break;
//	   		}

	}
	//	FIELD_CONTROL.chooseAutoMode();
//		m_autonomousCommand = m_chooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

//		// schedule the autonomous command (example)
//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.start();
//		}
	/**
	 * This function is called periodically during autonomous.
	 */	
	@Override
	public void autonomousPeriodic() {	
		Scheduler.getInstance().run();
	}
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}
	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {	 
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
