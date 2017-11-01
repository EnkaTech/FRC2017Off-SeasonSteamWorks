package org.usfirst.frc.team6985.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6985.robot.commands.Panel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
/**
 *
 */
public class RaiseLowerPanel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController lifterMotor = new Victor(5);
	
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

