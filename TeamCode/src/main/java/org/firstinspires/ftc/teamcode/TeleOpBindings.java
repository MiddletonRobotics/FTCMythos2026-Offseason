package org.firstinspires.ftc.teamcode;

import com.bylazar.gamepad.Gamepad;
import com.seattlesolvers.solverslib.command.button.Trigger;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Commands.DrivetrainController;
import org.firstinspires.ftc.teamcode.subsystems.Mythos;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain;

public class TeleOpBindings {
    private GamepadEx driver1;
    private Mythos robot;

    public TeleOpBindings(GamepadEx driver1, Mythos robot) {
        this.driver1 = driver1;
        this.robot = robot;
    }

    public void configureDefaultCommands() {
        robot.dt.setDefaultCommand(
                new DrivetrainController(
                        robot,
                        driver1::getLeftX,
                        driver1::getLeftY,
                        driver1::getRightX,
                        Mythos.Alliance.RED
                ));

    }

    public void controlMap() {
        //button actions
    }
}
