package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.RobotMap;
import org.usfirst.frc.team6985.robot.commands.SingleMotorBabe;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SingleMotor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController motor1 = new Victor(8);
	private SpeedController motor2 = new Victor(7);
	
	
	
    public void initDefaultCommand() {
    	setDefaultCommand(new SingleMotorBabe());
    }
    public void open(Joystick joy) {
    	motor1.set(joy.getRawAxis(5));
    	motor2.set(joy.getRawAxis(5));
    } 
    public void finish() {
    	motor1.set(0);
    	motor2.set(0);
}
}