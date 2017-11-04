
package org.usfirst.frc.team6985.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team6985.robot.subsystems.Climber;
import org.usfirst.frc.team6985.robot.subsystems.DriveSystem;
import org.usfirst.frc.team6985.robot.subsystems.GripGear;
import org.usfirst.frc.team6985.robot.subsystems.MoveGripper;

public class Robot extends IterativeRobot {
	
	//Komutlarýn tanýmlanmasý
	public static OI oi;
	public static DriveSystem driveSystem;
	public static MoveGripper moveGripper;
	public static GripGear gripGear;
	public static Climber climber;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	//Robot baþladýðýnda çalýþacak kod
	@Override
	public void robotInit() {
		
		//Komutlarýn iþlevselleþtirilmesi 
		//TODO Kontrol edilecek.
		climber = new Climber();
		gripGear = new GripGear();
		oi = new OI();
		driveSystem = new DriveSystem();
		moveGripper = new MoveGripper();
		
		//FIRST'ün hazýr kamera çýktý alma kodu. Düzenlenmedi.
		new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(640, 480);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();
		SmartDashboard.putData("Auto mode", chooser);
	}

	//Robotun komutlarý durdurmadan çalýþtýrdýpý son kod
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	//DOKUNMAYIN. OTONOM ÇAILIÞILMADI.
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		//DOKUNMAYIN. OTONOM ÇALIÞILMADI.
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	//Bu fonksiyon otonom sýrasýnda periyodik olarak çalýþýr. Modem baðlantýsýna göre yaklaþýk 20 ms'te bir çalýþýr. (Koddan gözlendi.)
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	//Teleoperatör baþlatýldýðnda baþlayacak olan kod.
	@Override
	public void teleopInit() {
		//FIRST'ün gömdüðü komut teleoperatör baþlarken otonomun durmasýný saðlýyor. (Deðiþtirilebilir.)
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	//Teleoperatör sýrasýnda periyodik bir þekilde tekrar eden kod.
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	//Test modu sýrasýnda periyodik bir þekilde tekrar eden kod.
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
