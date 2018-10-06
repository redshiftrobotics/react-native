package org.firstinspires.ftc.robotcontroller.internal;

import com.facebook.react.bridge.ReactMethod;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Shared Op Mode")
public class TestOpMode extends LinearOpMode {

    private DcMotor[] motors = new DcMotor[1024];
    private int motorCount = 0;

    public String testValue = "TEST";

    @Override
    public void runOpMode() {
        ((FtcRobotControllerActivity) this.hardwareMap.appContext).shairedOpMode = this;
        telemetry.addData("op mode: ", ((FtcRobotControllerActivity) this.hardwareMap.appContext).shairedOpMode.testValue);

        telemetry.addData("initializing...", "");
        telemetry.update();

        telemetry.addData("done.", "");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) continue;
    }

    public int getDCMotor(String name) {
        motors[motorCount] = hardwareMap.dcMotor.get(name);
        motorCount++;

        return motorCount - 1;
    }

    public void setPower(int motorIndex, double power) {
        motors[motorIndex].setPower(power);
    }
}

