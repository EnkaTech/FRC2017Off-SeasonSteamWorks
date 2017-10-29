package org.usfirst.frc.team6985.robot.subsystems;

import org.usfirst.frc.team6985.robot.commands.JoystickDrive;
import edu.wpi.first.wpilibj.Joystick;
import libs.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

public class DriveSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController frontLeftMotor = new Victor(0);
	private SpeedController rearLeftMotor = new Victor(1);
	private SpeedController frontRightMotor = new Victor(2);
	private SpeedController rearRightMotor = new Victor(3);
	private RobotDrive driveSystem = new RobotDrive(frontLeftMotor,rearLeftMotor,frontRightMotor,rearRightMotor);
	@Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new JoystickDrive());
    }
	public void drive(double x,double y) {
	driveSystem.tankDrive(x,y);//(x, y);
}
	public void drive(Joystick joy) {
	drive(-joy.getY()*0.4,-joy.getRawAxis(5)*0.4);
}
}

