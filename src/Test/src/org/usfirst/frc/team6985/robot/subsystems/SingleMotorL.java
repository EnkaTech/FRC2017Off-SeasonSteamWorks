package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.commands.SingleMotorBabe;
import org.usfirst.frc.team6985.robot.commands.SingleMotorLeft;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */
public class SingleMotorL extends Subsystem {
	private SpeedController motor1 = new Victor (5);
	private SpeedController motor2 = new Victor(6);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void initDefaultCommand() {
    	setDefaultCommand(new SingleMotorLeft());
    }
    public void open(Joystick joy) {
    	motor1.set(-joy.getY());
    	motor2.set(-joy.getY());
    } 
    public void finish() {
    	motor1.set(0);
    	motor2.set(0);
}
}

