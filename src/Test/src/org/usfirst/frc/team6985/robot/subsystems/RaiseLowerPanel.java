package org.usfirst.frc.team6985.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;


import org.usfirst.frc.team6985.robot.commands.JoystickDrive;
import org.usfirst.frc.team6985.robot.commands.Panel;

import edu.wpi.first.wpilibj.Joystick;
import libs.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
/**
 *
 */
public class RaiseLowerPanel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController lifterMotor = new Victor(4);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Panel());

    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void lift(double l, double r) {
    	lifterMotor.set((l+r));
    }
    
	public void lift(Joystick joy){
		lift(-joy.getRawAxis(2),joy.getRawAxis(3));
	}
}

