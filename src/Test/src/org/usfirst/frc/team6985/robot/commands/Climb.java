package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 YALNIZCA JOYSTICK DRIVE BÖLÜMÜNDE FONKSİYONLARIN AYRINTILI ANLATIMLARI VARDIR.
 */

//Tırmanma mekanizması komutu.
public class Climb extends Command {
double speed;
    public Climb(double x) {
    	this.speed=x;
    	requires(Robot.climber);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.climb(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.climb(0);
    }


    protected void interrupted() {
    }
}
