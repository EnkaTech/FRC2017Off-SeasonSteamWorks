package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
YALNIZCA JOYSTICK DRIVE ÝÇÝNDE FONKSÝYONLARIN AYRINTILI ANLATIMLARI VARDIR.
*/

//Gripperý kaldýran komut.
public class LiftGripper extends Command {

    public LiftGripper() {
    	requires(Robot.moveGripper);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.moveGripper.lift(Robot.oi.joy);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.moveGripper.lift(0,0);
    }

    protected void interrupted() {
    }
}
