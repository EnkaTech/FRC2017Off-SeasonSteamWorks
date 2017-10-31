package org.usfirst.frc.team6985.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	SpeedController motor1 = new Victor(6);
	SpeedController motor2 = new Victor(7);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void climb(double x) {
    	motor1.set(x);
    	motor2.set(x);
    }
}

