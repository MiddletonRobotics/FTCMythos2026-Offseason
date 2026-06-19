package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Mythos {
    public final Drivetrain drivetrain;

    public Mythos(HardwareMap hardwareMap) {
        drivetrain = new Drivetrain(hardwareMap, "Drivetrain");
    }


}
