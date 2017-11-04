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
	
    //Robot hareketini sa�layan motorlar�n tan�mlanmas�.
	private SpeedController frontLeftMotor = new Victor(1);
	private SpeedController rearLeftMotor = new Victor(2);
	private SpeedController frontRightMotor = new Victor(3);
	private SpeedController rearRightMotor = new Victor(4);
	//S�r�� sisteminin kendi k�t�phanemizden �ekilmesi.
	private RobotDrive driveSystem = new RobotDrive(frontLeftMotor,rearLeftMotor,frontRightMotor,rearRightMotor);
	@Override
    public void initDefaultCommand() {
    	//Alt sistem i�in ana komutun belirlenmesi. Alt sistemler birden fazla komuuta olabilse de bir ana komut olmak zorunda.
		setDefaultCommand(new JoystickDrive());
    }
	public void drive(double x,double y) {
		//Rakamlara g�re s�r�� yap�lmas�.
		//TODO �ki komutun neden ayn� anda oldu�u belirlenecek.
		driveSystem.tankDrive(x,y);
}
	public void drive(Joystick joy) {
		//Joystick ��kt�lar�na g�re s�r�� yap�lmas�.
		//TODO Tespitlerime g�re a�a��daki komut hi� kullan�lm�yor.
		drive(-joy.getY(),-joy.getRawAxis(5));
}
}

