package org.firstinspires.ftc.teamcode;

import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.StartEndCommand;
import com.seattlesolvers.solverslib.command.button.Button;
import com.seattlesolvers.solverslib.command.button.GamepadButton;
import com.seattlesolvers.solverslib.command.button.Trigger;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Commands.DrivetrainController;
import org.firstinspires.ftc.teamcode.subsystems.Mythos;

public class TeleOpBindings {
    private final GamepadEx driver1;
    private final Mythos robot;

    private final Trigger ballIntake;
    private final Trigger ballOuttake;
    private final Button shooterSpin;


    public TeleOpBindings(GamepadEx driver1, Mythos robot) {
        this.driver1 = driver1;
        this.robot = robot;

        ballIntake = new Trigger(() -> driver1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.5);
        ballOuttake = new Trigger(() -> driver1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.5);
        shooterSpin = new GamepadButton(driver1, GamepadKeys.Button.Y);
    }

    public void controlMap() {
        //intake
        ballIntake.whileActiveContinuous(
                new StartEndCommand(robot.intake::intake, robot.intake::stopIntake)
        );
        ballOuttake.whileActiveContinuous(
                new StartEndCommand(robot.intake::outtake, robot.intake::stopIntake)
        );

        //turret
        //shoot me later I just like having the stuff in order

        //shooter
        shooterSpin.whenPressed(
                new StartEndCommand(robot.shooter::fullSpin, robot.shooter::stopShooter)
        );
    }

    public void configureDefaultCommands() {
        //drivetrain
        robot.drivetrain.setDefaultCommand(new DrivetrainController(
                robot.drivetrain,
                () -> -driver1.getLeftY(),
                () -> -driver1.getRightX(),
                () -> driver1.getLeftX()
        ));
    }
}
