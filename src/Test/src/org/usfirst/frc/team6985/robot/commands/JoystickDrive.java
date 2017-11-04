package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.OI;
import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;


public class JoystickDrive extends Command {
	Joystick joy = Robot.oi.joy;
	double a;
    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.increaseSensitivity.get()){
    		this.a=0.45;
    	}
    	else if(Robot.oi.powerup.get()) {
    		this.a=1.5;
    	}
    	else {
    		this.a=0.75;
    	}
    	
    	Robot.driveSystem.drive(-joy.getY()*a,-joy.getRawAxis(5)*a);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
