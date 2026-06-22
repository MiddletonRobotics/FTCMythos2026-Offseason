package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Mythos {
    public final Drivetrain drivetrain;
    public final Intake intake;

    public Mythos(HardwareMap hardwareMap) {
        drivetrain = new Drivetrain(hardwareMap, "Drivetrain");
        intake = new Intake(hardwareMap, "LowerIntake");
    }


}
