package org.usfirst.frc.team6985.robot.subsystems;


import org.usfirst.frc.team6985.robot.commands.Gear;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearCollector extends Subsystem {
	private SpeedController motor = new Victor(7);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Gear(0));
    }
    public void roll(double x) {
    	motor.set(x);
    }
}

