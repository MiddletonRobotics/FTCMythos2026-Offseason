package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Mythos {
    public drivetrain dt;

    public Mythos(HardwareMap hardwareMap) {
        dt = new drivetrain(hardwareMap);
    }

    public enum Alliance {
        RED, BLUE;
    }


}
