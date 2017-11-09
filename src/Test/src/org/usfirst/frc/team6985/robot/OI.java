package org.usfirst.frc.team6985.robot;

import org.usfirst.frc.team6985.robot.commands.Climb;
import org.usfirst.frc.team6985.robot.commands.Gear;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	//Joystick ve butonların tanımlanması.
	public Joystick joy = new Joystick(0);
	public JoystickButton buttonA = new JoystickButton(joy, 1);
	public JoystickButton buttonB = new JoystickButton(joy, 2);
	public JoystickButton buttonX = new JoystickButton(joy, 3);
	public JoystickButton powerup = new JoystickButton(joy, 6);
	public JoystickButton increaseSensitivity = new JoystickButton(joy, 5);
	public OI() 
	{
		//Butonlara basılmasına göre fonkisyon çalıştırılması.
		buttonB.whileHeld(new Gear(1));
		buttonA.whileHeld(new Gear(-1));
		buttonX.whileHeld(new Climb(-0.5));
	}

}