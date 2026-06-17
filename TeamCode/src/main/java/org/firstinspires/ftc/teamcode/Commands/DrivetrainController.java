package org.firstinspires.ftc.teamcode.Commands;

import com.pedropathing.Drivetrain;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.Subsystem;

import org.firstinspires.ftc.teamcode.subsystems.Mythos;

public class DrivetrainController extends CommandBase {
    private final Drivetrain dt;
    private final Mythos.Alliance color;

    public DrivetrainController(Drivetrain dt, Mythos.Alliance color) {
        this.dt = dt;
        this.color = color;

        addRequirements((Subsystem) dt);
    }
}
