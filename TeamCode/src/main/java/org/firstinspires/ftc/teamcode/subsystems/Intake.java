package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

public class Intake extends SubsystemBase {
    private final Motor frontIntake;
    private final Motor backIntake;

    public Intake(final HardwareMap hMap, final String name) {
        frontIntake = new Motor(hMap, "frontIntake", Motor.GoBILDA.RPM_312);
        backIntake = new Motor(hMap, "backIntake", Motor.GoBILDA.RPM_312);

        frontIntake.setInverted(true);
        backIntake.setInverted(true);

        frontIntake.setRunMode(Motor.RunMode.RawPower);
        backIntake.setRunMode(Motor.RunMode.RawPower);
    }

    public void setLowerPower(double speed) {
        frontIntake.set(speed);
    }

    public void setHigherPower(double speed) {
        backIntake.set(speed);
    }

    public void intake() {
        frontIntake.set(1);
        backIntake.set(1);
    }

    public void outtake() {
        frontIntake.set(-1);
        backIntake.set(-1);
    }

    public void stop() {
        frontIntake.set(0);
        backIntake.set(0);
    }
}
