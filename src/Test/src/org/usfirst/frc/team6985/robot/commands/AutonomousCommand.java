package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;
import org.usfirst.frc.team6985.robot.subsystems.MoveGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
    	
    	switch(Robot.oi.ds.getLocation()) {
    	
    	case 2:
    	
        addSequential(new Gyroverse(7.75,true));
        addSequential(new TimedGrip(0.5));
        break;
    	case 1:
 
    	addSequential(new Gyroverse(7.1,true));
    	addSequential(new GyroTurn(60));
    	addSequential(new Gyroverse(5,true));
    	addSequential(new MoveGripper.lift(0.5), 0.4);
    	addSequential(new TimedGrip(0.5));	
    	break;
    	case 3:
    		
    	addSequential(new Gyroverse(6.0,true));
        addSequential(new GyroTurn(-30));
        addSequential(new Gyroverse(1.0,true));
        addSequential(new TimedGrip(0.5));	
    	break;
        
    	}
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
