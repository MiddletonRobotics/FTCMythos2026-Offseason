package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.drivebase.MecanumDrive;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

public class drivetrain extends SubsystemBase {
    private final MecanumDrive drive;

    public drivetrain(HardwareMap hardwareMap) {
        Motor frontLeft = new Motor(hardwareMap, "frontLeft");
        Motor frontRight = new Motor(hardwareMap, "frontRight");
        Motor backLeft = new Motor(hardwareMap, "backLeft");
        Motor backRight = new Motor(hardwareMap, "backRight");

        frontLeft.setInverted(true);
        backLeft.setInverted(true);

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    }

    public void driveRobotCentric(double strafe, double forward, double turn) {
        drive.driveRobotCentric(strafe, forward, turn);
    }
}