package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

public class Turret extends SubsystemBase {
    private final Motor turret;

    public Turret(final HardwareMap hMap, final String name) {
        turret = new Motor(hMap, "turret", Motor.GoBILDA.RPM_312);
    }
}
