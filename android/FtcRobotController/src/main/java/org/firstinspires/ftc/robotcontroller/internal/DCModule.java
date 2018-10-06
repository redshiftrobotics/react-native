package org.firstinspires.ftc.robotcontroller.internal;

import android.app.Activity;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.MotorConfigurationType;
import com.qualcomm.robotcore.util.Hardware;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.RegEx;

class TestClass {

}

public class DCModule extends ReactContextBaseJavaModule {

    private static final String TEST_VALUE = "FOO";

    private FtcRobotControllerActivity mainActivity;

   public DCModule(ReactApplicationContext reactContext) {
       super(reactContext);

       this.mainActivity = (FtcRobotControllerActivity) reactContext.getCurrentActivity();
   }

    @Override
    public String getName() {
        return "DCTest";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("motor", "VALUE");
        return constants;
    }

    @ReactMethod
    public void start() {
       mainActivity.shairedOpMode.runOpMode();
    }

    @ReactMethod
    public void init() {
        mainActivity.shairedOpMode.init();
        mainActivity.shairedOpMode.start();
    }

    @ReactMethod
    public int getDCMotor(String name) {
        return this.mainActivity.shairedOpMode.getDCMotor(name);
    }

    @ReactMethod
    public void setPower(int motorIndex, double power) {
       this.mainActivity.shairedOpMode.setPower(motorIndex, power);
    }

    @ReactMethod
    public String test() {
        return this.mainActivity.shairedOpMode.testValue;
    }
}
