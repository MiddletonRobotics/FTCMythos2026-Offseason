package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter extends SubsystemBase {
    private final Motor shooter;

    private final ServoEx hoodServo;
    private final ServoEx blockerServo;

    private final Telemetry telemetry;

    public Shooter(final HardwareMap hMap, final String name, Telemetry telemetry) {
        shooter = new Motor(hMap, "shooter", Motor.GoBILDA.BARE);
        shooter.setRunMode(Motor.RunMode.RawPower);
        shooter.setInverted(true);

        hoodServo = new ServoEx(hMap, "hoodServo", 0, 70);
        hoodServo.setInverted(true);
        hoodServo.set(0);

        blockerServo = new ServoEx(hMap, "blockerServo", 0, 1);
        blockerServo.set(0);

        this.telemetry = telemetry;
    }

    public void periodic() {
        double ticksPerSecond = shooter.getCorrectedVelocity();
        double rpm = (ticksPerSecond / shooter.getCPR()) * 60.0;

        telemetry.addData("Shooter RPM", rpm);
    }

    public void fullSpin() {
        shooter.set(1.0);
    }

    public void stopShooter() {
        shooter.set(0);
    }

    public void rotateHood() {
        hoodServo.set(0);
    }

    public void rotateHood2() {
        hoodServo.set(70);
    }

    public void blockerUp() {
        blockerServo.set(2);
    }

    public void blockerDown() {
        blockerServo.set(0);
    }
}
