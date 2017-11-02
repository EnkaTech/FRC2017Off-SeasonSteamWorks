package org.usfirst.frc.team6985.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6985.robot.commands.Panel;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
/**
 *
 */
public class RaiseLowerPanel extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController lifterMotor = new Spark(8);
	
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

