package org.usfirst.frc.team6985.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6985.robot.commands.LiftGripper;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class MoveGripper extends Subsystem {

    //Gripperı kaldırıp indiren motorun tanımlanması.
	private SpeedController lifterMotor = new Spark(8);
	
    public void initDefaultCommand() {
    	//Alt sistem için ana komutun belirlenmesi. Alt sistemler birden fazla komuuta olabilse de bir ana komut olmak zorunda.
    	setDefaultCommand(new LiftGripper());
    }
    public void lift(double l, double r) {
    	//Motor sürücülerin joystick çıktıların göre hareket ettirilmesi.
    	lifterMotor.set((l+r));
    }
    
	public void lift(Joystick joy){
		//Joystick çıktılarına göre gripperın yükselip alçaltılması.
		lift(-joy.getRawAxis(2),joy.getRawAxis(3));
	}
}

