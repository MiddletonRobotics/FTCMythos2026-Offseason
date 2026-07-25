package org.firstinspires.ftc.teamcode;

import static com.seattlesolvers.solverslib.gamepad.GamepadExExtKt.whenInactive;

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

    //Intake
    private final Trigger ballIntake;
    private final Trigger ballOuttake;

    //Shooter
    private final Button shooterSpin;
    private final Button hoodSpin;
    private final Button hoodSpin2;
    private final Button blockerUp;
    private final Button blockerDown;

    public TeleOpBindings(GamepadEx driver1, Mythos robot) {
        this.driver1 = driver1;
        this.robot = robot;

        ballIntake = new Trigger(() -> driver1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.5);
        ballOuttake = new Trigger(() -> driver1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.5);

        shooterSpin = new GamepadButton(driver1, GamepadKeys.Button.RIGHT_STICK_BUTTON);
        hoodSpin = new GamepadButton(driver1, GamepadKeys.Button.Y);
        hoodSpin2 = new GamepadButton(driver1, GamepadKeys.Button.X);
        blockerUp = new GamepadButton(driver1, GamepadKeys.Button.A);
        blockerDown = new GamepadButton(driver1, GamepadKeys.Button.B);
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
        shooterSpin.whenActive(robot.shooter::fullSpin)
                    .whenInactive(robot.shooter::stopShooter);
        hoodSpin.whenActive(robot.shooter::rotateHood);
        hoodSpin2.whenActive(robot.shooter::rotateHood2);
        blockerUp.whenActive(robot.shooter::blockerUp);
        blockerDown.whenActive(robot.shooter::blockerDown);

    }

    public void configureDefaultCommands() {
        //drivetrain
        robot.drivetrain.setDefaultCommand(new DrivetrainController(
                robot.drivetrain,
                () -> -driver1.getLeftY(),
                () -> -driver1.getRightX(),
                () -> -driver1.getLeftX()
        ));
    }
}
