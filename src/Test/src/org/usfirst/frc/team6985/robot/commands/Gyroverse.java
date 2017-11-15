package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */

public class Gyroverse extends TimedCommand {
	boolean x;
    public Gyroverse(double timeout, boolean x) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveSystem);
        this.x=x;
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.oi.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.GyroDrive((Robot.oi.gyro),x);
    }

    // Called once after timeout
    protected void end() {
    	Robot.driveSystem.drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
