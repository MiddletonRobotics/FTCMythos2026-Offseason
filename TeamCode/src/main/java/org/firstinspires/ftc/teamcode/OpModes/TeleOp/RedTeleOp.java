package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.Commands.DrivetrainController;
import org.firstinspires.ftc.teamcode.TeleOpBindings;
import org.firstinspires.ftc.teamcode.subsystems.Mythos;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain;

@TeleOp(name="RedTeleOp")
public class RedTeleOp extends CommandOpMode {

    private Mythos robot;
    private GamepadEx driver1;
    private TeleOpBindings bindings;

    @Override
    public void initialize() {
        robot = new Mythos(hardwareMap);

        driver1 = new GamepadEx(gamepad1);

        bindings = new TeleOpBindings(driver1, robot);
        bindings.controlMap();
        bindings.configureDefaultCommands();
    }
}