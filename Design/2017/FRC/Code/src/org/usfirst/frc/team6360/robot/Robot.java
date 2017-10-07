package org.usfirst.frc.team6360.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Robot extends IterativeRobot
{
	double xpath=0,ypath=0,xspeed=0,yspeed=0;
	Joystick stick;
	RobotDrive robot;
	Victor lift,grabmotor1,grabmotor2;
	ADXRS450_Gyro  gyro;
	Timer timer;
	BuiltInAccelerometer accelerometer;
	int count=0;
	
	public void robotInit()
	{
		Thread visionThread;
		stick			= new Joystick(0);
		robot			= new RobotDrive(0,1,2,3);
		lift			= new Victor(9);
		gyro			= new ADXRS450_Gyro();
		grabmotor1		= new Victor(7);
		grabmotor2		= new Victor(8);	
		timer			= new Timer();
		accelerometer	= new BuiltInAccelerometer();

		visionThread = new Thread
		(() -> 
		{
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);
			Mat mat = new Mat();
			while (!Thread.interrupted())
			{
				if (cvSink.grabFrame(mat) == 0)
				{
					outputStream.notifyError(cvSink.getError());
					continue;
				}
				Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400),new Scalar(255, 255, 255), 5);
				outputStream.putFrame(mat);
			}
		}			
		);
		visionThread.setDaemon(true);
		visionThread.start();

	}

	public void autonomousInit() 
	{
		count = 0;
		gyro.reset();
		timer.reset();
	}

	public void autonomousPeriodic()
	{	
		
		/*robot.mecanumDrive_Cartesian(0.5,0,0,gyro.getAngle());
		timer.reset();
		timer.start();
		xspeed = xspeed + accelerometer.getX()*timer.get();
		yspeed = yspeed + accelerometer.getY()*timer.get();
		xpath = xpath + xspeed*timer.get();
		ypath = ypath + yspeed*timer.get();
		if (timer.get() >= 4)
		{
			robot.mecanumDrive_Cartesian(0,0,0,gyro.getAngle());
		}*/
		//timer.stop();
		//timer.reset();
		count++;
		if (count <= 150)
		{
			robot.mecanumDrive_Cartesian(1,0,0,gyro.getAngle());
		}
		else
		{
			robot.mecanumDrive_Cartesian(0,0,0,gyro.getAngle());
		}
		//robot.mecanumDrive_Cartesian(stick.getZ(),stick.getX(),stick.getY(),gyro.getAngle());
	}
	
	public void telepInti()
	{
	timer.reset();
	}
	
	public void teleopPeriodic() 
	{
		//robot.mecanumDrive_Polar(-stick.getX(), stick.getZ(),stick.getY());
		robot.mecanumDrive_Cartesian(stick.getX(),stick.getZ(),stick.getY(),gyro.getAngle());
		if (stick.getRawButton(1))		{	robot.setMaxOutput(1);	}
		else if (stick.getRawButton(2))	{	robot.setMaxOutput(0.6);}
		else							{	robot.setMaxOutput(0.8);}
		if (stick.getRawButton(6))		{	grabmotor1.set(-1);		grabmotor2.set(-1);}
		else if (stick.getRawButton(4))	{	grabmotor1.set(0.6);	grabmotor2.set(0.6);}
		else 							{	grabmotor1.set(0);		grabmotor2.set(0);}
		if (stick.getRawButton(5))		{	lift.set(1);	}
		else if (stick.getRawButton(3))	{	lift.set(-1);	}
		else							{	lift.set(0);	}
	}
	
	public void disableInit()
	{
		//grabmotor1.set(0.5);
		//grabmotor2.set(0.5);
		//Timer.delay(3);
		//grabmotor1.set(-0.3);
		//grabmotor2.set(-0.3);
		//Timer.delay(3);
		//grabmotor1.set(0);
		//grabmotor2.set(0);
	}
	
	public void diabalePeridic()
	{
	}
	
	public void testInti()
	{
	}
	
	public void testPeriodic() 
	{
	}
}
