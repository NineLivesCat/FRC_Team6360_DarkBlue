package org.usfirst.frc.team6360.robot.commands;

import org.usfirst.frc.team6360.robot.Robot;
import org.usfirst.frc.team6360.robot.RobotMap;

import com.sun.jmx.snmp.internal.SnmpAccessControlSubSystem;
import com.sun.org.apache.bcel.internal.generic.LMUL;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Auto_Drivetrain_turing2 extends Command{
	double angle;
	double error;
	//double error2;
	double speed;
	double integral;
	//double previous_error;
	double derivative ;
	// int P, I, D = 1;
	 double rcw;
	//PIDControlle r pidController;
	public Auto_Drivetrain_turing2(int angle) {
		requires(Robot.drivetrain);
		this.angle = (angle*3.14)/180*2; 
	}
	protected void  initialize() {
		Robot.drivetrain.getLeftEncoder().reset();
		Robot.drivetrain.getLeftEncoder().setDistancePerPulse(1.0/360);
		if(angle>0) {
			speed = 0.6;
		}else {
			speed = -0.6;
		}
		System.out.println(RobotMap.AutoTurningMessage + angle);
	}
	protected void execute() {
		//pid();
		//System.out.println("errot"+error); 
		Robot.drivetrain.setTankDrive(0,speed); 
		if(Robot.drivetrain.getLeftEncoder().getDistance()>Math.abs(angle)*0.61+0.0001) {
			Robot.drivetrain.setTankDrive(0,-speed); 
		}
		System.out.println(Robot.drivetrain.getLeftEncoder().getDistance());
		//Robot.drivetrain.setArcadeDrive(0, -rcw);
	}
	@Override
	protected void end() {
		//Robot.drivetrain.setArcadeDrive(0, 0);
		Robot.drivetrain.setTankDrive(0,0);
	}    
	@Override 
	protected boolean isFinished() {
		if(Math.abs(Robot.drivetrain.getLeftEncoder().getDistance())>(Math.abs(angle)*0.61-0.001)&&Robot.drivetrain.getLeftEncoder().getDistance()<(Math.abs(angle)*0.61+0.001)) {			
			return true;
		}
//		if(Robot.navx.getAhrs().getYaw()>angle-5&Robot.navx.getAhrs().getYaw()<angle+5) {
//			return true;
//		}
		return false;
	}
}
//public void pid() {
//	//differential how fast it is changing
//	derivative = (error-(angle - Robot.navx.getAhrs().getYaw())/0.025)*-0.006;
//	//proportional
//	error = (angle - Robot.navx.getAhrs().getYaw())*0.025;
//	//integral  
//	integral += error*0.002;
//	System.out.println("P"+error);
//	System.out.println("I"+integral);
//	System.out.println("D"+derivative);
//	rcw = error +integral +derivative;
//	if(rcw>0.58) {
//		rcw = 0.58;
//	}
//	if(rcw<-0.58) {
//		rcw = -0.58;
//	}
//	if(rcw<0.44&&rcw>0) {
//		rcw=0.44;
//	}
//	if(rcw>-0.44&&rcw<0) {
//		rcw=-0.44;
//	}
//}