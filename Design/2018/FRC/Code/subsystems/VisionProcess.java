package org.usfirst.frc.team6360.robot.subsystems;

import java.awt.Color;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VisionProcess extends Subsystem {
	private Thread visionThread;
	public VisionProcess() {
		setVisionThread(new Thread(() -> {
	
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream
			= CameraServer.getInstance().putVideo("Rectangle", 640, 480);
			Mat mat = new Mat();
			Mat temp = new Mat();
		 	int num_rows = mat.rows();
			int num_col = mat.cols();
			int channels = mat.channels();
			int stride = channels * num_col;
			int totalBytes = (int)(mat.total() * mat.channels());
			int buff[] = new int[totalBytes];
			 float hueSum = 0;
			 float hueAvg = 0;
			 float satSum = 0;
			 float satAvg = 0;
			 float valSum = 0;
			 float valAvg = 0;
			for(int i = 0; i <num_rows; i++) {
					for(int j = 0 ; j<num_col;j++) {
						int r = buff[(i * stride) + j];
			            int g = buff[(i * stride) + j + 1]; 
			            int b = buff[(i * stride) + j + 2];
			            float[] hsv = new float[3];
			            Color.RGBtoHSB(r,g,b,hsv);
			            
			            hueSum += hsv[0];
			            satSum += hsv[1];
			            valSum += hsv[2];
			            
					}
			}
			hueAvg = hueSum / 400;
		    satAvg = satSum / 400;
		    valAvg = valSum / 400;
		    
		    int finalHue = Math.round(hueAvg*180);
		    int finalSat = Math.round(satAvg*100);
		    int finalVal = Math.round(valAvg*100);
		    
		    if(finalHue >= 0 && finalHue <= 4 || finalHue >= 150 && finalHue <= 180){
		        System.out.println("RED");
		    }
		    else if(finalHue >= 5 && finalHue <= 20){
		        System.out.println("ORANGE");
		    }
		    else if(finalHue >= 21 && finalHue <= 45){
		        System.out.println("YELLOW");
		    }
		    else if(finalHue >=  46 && finalHue <= 90){
		        System.out.println("GREEN");
		    }
		    else if(finalHue >= 91 && finalHue <= 150){
		        System.out.println("BLUE");
		    }
			outputStream.putFrame(mat);
					}));
		visionThread.setDaemon(true);
		visionThread.start();
	}
	@Override
	protected void initDefaultCommand() {
	}
	public Thread getVisionThread() {
		return visionThread;
	}
	public void setVisionThread(Thread visionThread) {
		this.visionThread = visionThread;
	}	
}
