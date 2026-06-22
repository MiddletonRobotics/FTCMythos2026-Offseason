package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Mythos {
    public final Drivetrain drivetrain;
    public final Intake intake;
    public final Turret turret;
    public final Shooter shooter;

    public Mythos(HardwareMap hardwareMap, Telemetry telemetry) {
        drivetrain = new Drivetrain(hardwareMap, "Drivetrain");
        intake = new Intake(hardwareMap, "LowerIntake");
        turret = new Turret(hardwareMap, "Turret");
        shooter = new Shooter(hardwareMap, "Shooter", telemetry);
    }


}
