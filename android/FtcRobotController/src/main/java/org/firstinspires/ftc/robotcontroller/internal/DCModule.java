package org.firstinspires.ftc.robotcontroller.internal;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
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

class TestClass {

}

public class DCModule extends ReactContextBaseJavaModule {

    private static final String TEST_VALUE = "FOO";

   public DCModule(ReactApplicationContext reactContext) {
       super(reactContext);
   }

    @Override
    public String getName() {
        return "DCTest";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("motor", DCModule.TEST_VALUE);
        return constants;
    }
}
