package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Demo Op Mode")
public class TestOpMode extends LinearOpMode {

    DcMotor leftMotor = null;
    DcMotor rightMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("initializing...", "");
        telemetry.update();

        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");

        telemetry.addData("done.", "");
        telemetry.update();

        waitForStart();

        while (opModeIsActive() && leftMotor != null && rightMotor != null) {
            leftMotor.setPower(gamepad1.left_stick_x);
            rightMotor.setPower(-gamepad1.left_stick_x);
        }
    }
}

