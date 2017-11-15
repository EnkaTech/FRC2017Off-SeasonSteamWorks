package org.usfirst.frc.team6985.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
        addSequential(new Gyroverse(5,true));
        addSequential(new TimedGrip(0.5));
        addSequential(new Gyroverse(3,false));
        addSequential(new GyroTurn(45));
        addSequential(new Gyroverse(3,true));
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
