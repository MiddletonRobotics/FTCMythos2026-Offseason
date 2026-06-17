package org.firstinspires.ftc.teamcode;

import com.bylazar.gamepad.Gamepad;
import com.seattlesolvers.solverslib.command.button.Trigger;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.Mythos;

public class TeleOpBindings {
    private GamepadEx driver1;
    private GamepadEx driver2;

    //driver 1
    public Trigger spinFlywheel;

    //driver 2
    //yo i dont got a second controller

    private Mythos robot;

    public TeleOpBindings(GamepadEx driver1, GamepadEx driver2, Mythos robot) {
        this.robot = robot;
        this.driver1 = driver1;

        spinFlywheel = new Trigger(() -> driver1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.5);
    }

    public void controlMap() {
    }
}
