package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

//S�rme komutlar�.
public class JoystickDrive extends Command {
	Joystick joy = Robot.oi.joy;
	double a;
    public JoystickDrive() {
        //Komuta gereken altsistemlerin �a��r�lmas�.
    	requires(Robot.driveSystem);
    }

    //Komut ilk kez �al��maya ba�lad���nda �a�r�lan kod
    protected void initialize() {
    }

    //Komut �al���rken devaml� olarak �a�r�lan kod.
    protected void execute() {
    	
    	//Robotun h�z�n� ve hassasiyet ayar�n� veren kod.
    	if(Robot.oi.increaseSensitivity.get()){
    		this.a=0.45;
    	}
    	else if(Robot.oi.powerup.get()) {
    		this.a=1.5;
    	}
    	else {
    		this.a=0.75;
    	}
    	
    	Robot.driveSystem.drive(-joy.getY()*a,-joy.getRawAxis(5)*a);
    }

    //Bunun do�ru ��kt� vermesi komutu durdurur.
    protected boolean isFinished() {
        return false;
    }

    //isFinished do�ru de�er ald�ktan sonra bir kere �al��t�r�l�r.
    //TODO isFinished kullan�labilece�i i�in alttaki kod mevcut.
    protected void end() {
    	Robot.driveSystem.drive(0,0);
    }

    //Bu komutun gerektirdi�i bir alt sistemi gerektiren ba�ka bir komut �a�r�ld���nda kullan�lan kod.
    protected void interrupted() {
    }
}
