package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.commands.JoystickDrive;
import edu.wpi.first.wpilibj.Joystick;
import libs.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class DriveSystem extends Subsystem {
	
    //Robot hareketini saðlayan motorlarýn tanýmlanmasý.
	private SpeedController frontLeftMotor = new Victor(1);
	private SpeedController rearLeftMotor = new Victor(2);
	private SpeedController frontRightMotor = new Victor(3);
	private SpeedController rearRightMotor = new Victor(4);
	//Sürüþ sisteminin kendi kütüphanemizden çekilmesi.
	private RobotDrive driveSystem = new RobotDrive(frontLeftMotor,rearLeftMotor,frontRightMotor,rearRightMotor);
	@Override
    public void initDefaultCommand() {
    	//Alt sistem için ana komutun belirlenmesi. Alt sistemler birden fazla komuuta olabilse de bir ana komut olmak zorunda.
		setDefaultCommand(new JoystickDrive());
    }
	public void drive(double x,double y) {
		//Rakamlara göre sürüþ yapýlmasý.
		//TODO Ýki komutun neden ayný anda olduðu belirlenecek.
		driveSystem.tankDrive(x,y);
}
	public void drive(Joystick joy) {
		//Joystick çýktýlarýna göre sürüþ yapýlmasý.
		//TODO Tespitlerime göre aþaðýdaki komut hiç kullanýlmýyor.
		drive(-joy.getY(),-joy.getRawAxis(5));
}
}

