package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 YALNIZCA JOYSTICK DRIVE ÝÇÝNDE FONKSÝYONLARIN AYRINTILI ANLATIMLARI VARDIR.
 */

//Gripperý sýkýþtýran komut.
public class Gear extends Command {
double speed;
    public Gear(double x) {
    	this.speed=x;
    	requires(Robot.gripGear);
    }
    
    protected void initialize() {
    	
    }
    
    protected void execute() {
    	Robot.gripGear.grip(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.gripGear.grip(0);
    }

    protected void interrupted() {
    }
}
