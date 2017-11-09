package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.commands.Climb;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    //Tırmanma motorlarının tanımlanması
	SpeedController climbMotor1 = new Victor(5);
	SpeedController climbMotor2 = new Victor(6);

    public void initDefaultCommand() {
    	//Alt sistem için ana komutun belirlenmesi. Alt sistemler birden fazla komuuta olabilse de bir ana komut olmak zorunda.
    	setDefaultCommand(new Climb(0));
    }
    public void climb(double x) {
    	//Tırmanma motorlarının çalıştırlması.
    	climbMotor1.set(x);
    	climbMotor2.set(x);
    }
}

