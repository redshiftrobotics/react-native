package org.firstinspires.ftc.robotcontroller.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

import com.qualcomm.ftcrobotcontroller.FtcRobotControllerActivity;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Shared Op Mode")
@Disabled
public class TestOpMode extends LinearOpMode {

    private DcMotor[] motors = new DcMotor[1024];
    private int motorCount = 0;

    public String testValue = "TEST";

    @Override
    public void runOpMode() {
        System.out.println("testing app context: ");

        FtcRobotControllerActivity activity = (FtcRobotControllerActivity) this.hardwareMap.appContext;

        System.out.println(activity);


        // telemetry.addData("op mode: ", activity.shairedOpMode.testValue);
        // telemetry.update();

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

    private Activity getActivity(Context context) {
        if (context == null) {
            return null;
        } else if (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            } else {
                return getActivity(((ContextWrapper) context).getBaseContext());
            }
        }

        return null;
    }
}

