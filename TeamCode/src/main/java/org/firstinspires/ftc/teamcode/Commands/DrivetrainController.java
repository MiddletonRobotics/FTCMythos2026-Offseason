package org.firstinspires.ftc.teamcode.Commands;

import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Mythos;
import org.jetbrains.annotations.UnknownNullability;

import java.util.function.DoubleSupplier;

public class DrivetrainController extends CommandBase {
    private final Mythos robot;
    private final DoubleSupplier strafe, forward, turn;
    private final Mythos.Alliance color;

    // FIX: Change the first parameter from 'drivetrain dt' to 'Mythos robot'
    public DrivetrainController(@UnknownNullability Mythos robot, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn, Mythos.Alliance color) {
        this.robot = robot;
        this.strafe = strafe;
        this.forward = forward;
        this.turn = turn;
        this.color = color;

        addRequirements(robot.dt);
    }

    @Override
    public void execute() {
        robot.dt.driveRobotCentric(
                strafe.getAsDouble(),
                forward.getAsDouble(),
                turn.getAsDouble()
        );
    }
}