package org.usfirst.frc.team6985.robot.commands;

import org.usfirst.frc.team6985.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
    	
    	switch(Robot.oi.ds.getLocation()) {
    	
    	case 2:
    	
        addSequential(new Gyroverse(3.3,true));
        addSequential(new RemGripper(0.1));
        addSequential(new TimedGrip(0.5));
        addSequential(new Gyroverse(1.5, false));
        addSequential(new GyroTurn(45));
        addSequential(new Gyroverse(3, true));
        
        
        break;
    	case 1:
 
    	addSequential(new Gyroverse(3.9,true));
    	addSequential(new GyroTurn(60));
    	addSequential(new Gyroverse(2.8,true));
    	addSequential(new RemGripper(0.15));
    	addSequential(new TimedGrip(0.5));	
    	addSequential(new Gyroverse(1.5,false));
    	addSequential(new GyroTurn(-60));
    	addSequential(new Gyroverse(3,true));
    	
    	break;
    	case 3:
    		
    		addSequential(new Gyroverse(3.9,true));
        	addSequential(new GyroTurn(-60));
        	addSequential(new Gyroverse(2.8,true));
        	addSequential(new RemGripper(0.1));
        	addSequential(new TimedGrip(0.5));	
        	addSequential(new Gyroverse(1.5,false));
        	addSequential(new GyroTurn(60));
        	addSequential(new Gyroverse(3,true));        
        
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
