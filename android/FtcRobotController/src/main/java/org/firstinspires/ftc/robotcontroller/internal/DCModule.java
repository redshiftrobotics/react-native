package org.firstinspires.ftc.robotcontroller.internal;

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

    private TestOpMode mOpMode;

    private DcMotor[] motors = new DcMotor[1024];
    private int motorCount = 0;

   public DCModule(ReactApplicationContext reactContext) {
       super(reactContext);

       mOpMode = new TestOpMode();
   }

    @Override
    public String getName() {
        return "DCTest";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        final TestClass motor = new TestClass();
        constants.put("motor", motor);
        return constants;
    }

    @ReactMethod
    public void init() {
       mOpMode.runOpMode();
    }

    @ReactMethod
    public int getDCMotor(String name) {
        motors[motorCount] = mOpMode.hardwareMap.dcMotor.get(name);
        motorCount++;

        return motorCount - 1;
    }

    @ReactMethod
    public void setPower(int motorIndex, double power) {
       motors[motorIndex].setPower(power);
    }
}
