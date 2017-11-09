package org.usfirst.frc.team6985.robot.subsystems;


import org.usfirst.frc.team6985.robot.commands.Gear;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GripGear extends Subsystem {
	
	//Gripperı sıkıştıran motorun tanımlanması.
	private SpeedController motor = new Victor(7);

    public void initDefaultCommand() {
    	//Alt sistem için ana komutun belirlenmesi. Alt sistemler birden fazla komuuta olabilse de bir ana komut olmak zorunda.
    	setDefaultCommand(new Gear(0));
    }
    //Gripper ın çalıştırılması.
    public void grip(double x) {
    	motor.set(x);
    }
}

