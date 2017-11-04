package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

//Sürme komutlarý.
public class JoystickDrive extends Command {
	Joystick joy = Robot.oi.joy;
	double a;
    public JoystickDrive() {
        //Komuta gereken altsistemlerin çaðýrýlmasý.
    	requires(Robot.driveSystem);
    }

    //Komut ilk kez çalýþmaya baþladýðýnda çaðrýlan kod
    protected void initialize() {
    }

    //Komut çalýþýrken devamlý olarak çaðrýlan kod.
    protected void execute() {
    	
    	//Robotun hýzýný ve hassasiyet ayarýný veren kod.
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

    //Bunun doðru çýktý vermesi komutu durdurur.
    protected boolean isFinished() {
        return false;
    }

    //isFinished doðru deðer aldýktan sonra bir kere çalýþtýrýlýr.
    //TODO isFinished kullanýlabileceði için alttaki kod mevcut.
    protected void end() {
    	Robot.driveSystem.drive(0,0);
    }

    //Bu komutun gerektirdiði bir alt sistemi gerektiren baþka bir komut çaðrýldýðýnda kullanýlan kod.
    protected void interrupted() {
    }
}
