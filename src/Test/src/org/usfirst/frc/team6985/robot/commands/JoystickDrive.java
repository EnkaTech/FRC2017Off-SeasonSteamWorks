package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

//Sürme komutları.
public class JoystickDrive extends Command {
	Joystick joy = Robot.oi.joy;
	double a;
	public Gyro gyro = Robot.oi.gyro;

    public JoystickDrive() {
        //Komuta gereken altsistemlerin çalıştırılması.
    	requires(Robot.driveSystem);
    }

    //Komut ilk kez çalışmaya başladığında yürütülen kod.
    protected void initialize() {
    }

    //Komut çalışırken devamlı olarak tekrarlanan kod.
    protected void execute() {
    	
    	//Robotun hız ve hassasiyet ayarını veren kod.
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

    //Bunun doğru çıktı vermesi komutu durdurur.
    protected boolean isFinished() {
        return false;
    }

    //isFinished doğru değer aldıktan sonra bir kere çalıştırılır.
    //TODO isFinished kullanılabileceği için alttaki kod mevcut.
    protected void end() {
    	Robot.driveSystem.drive(0,0);
    }

    //Bu komutun gerektirdiği bir alt sistemi gerektiren başka bir komut çalıştırıldığında kullanılan kod.
    protected void interrupted() {
    }
}
