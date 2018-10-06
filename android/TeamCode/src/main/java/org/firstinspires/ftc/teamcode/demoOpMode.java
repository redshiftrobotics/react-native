package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "(Broken) Demo Op Mode")
@Disabled
public class demoOpMode extends LinearOpMode {

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
