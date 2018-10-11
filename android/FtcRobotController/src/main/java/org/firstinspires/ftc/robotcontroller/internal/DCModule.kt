package org.firstinspires.ftc.robotcontroller.internal

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.ContextWrapper
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import java.util.HashMap

class DCModule: ReactContextBaseJavaModule {

	// simple value to test constants
	private val TEST_VALUE = "FOO"

	// main activity so that we can get the shared op mode
	private var mainActivity: FtcRobotControllerActivity? = null

	// holding our react context incase we want to update our main activity
	private var mContext: ReactApplicationContext? = null

	constructor(reactContext: ReactApplicationContext): super(reactContext) {
		println("Given context: ")
		println(reactContext)

		// set the main activity from the context we are given
		this.mainActivity = reactContext.currentActivity as FtcRobotControllerActivity?
		this.mContext = reactContext
	}

	override fun getName(): String {
		return "DCTest"
	}

	override fun getConstants(): Map<String, Any>? {
		val constants = HashMap<String, Any>()
		constants["motor"] = "VALUE"
		return constants
	}

	@ReactMethod
	fun getDCMotor(name: String, cb: Callback) {
		cb.invoke(sharedOpMode!!.getDCMotor(name))
	}

	@ReactMethod
	fun setPower(motorIndex: Int, power: Double) {
	   sharedOpMode!!.setPower(motorIndex, power)
	}

	@ReactMethod
	fun test(): String {
		return sharedOpMode!!.testValue
	}

	@ReactMethod
	fun telemetry(message: String) {
	   sharedOpMode!!.telemetry.addData("> ", message)
	   sharedOpMode!!.telemetry.update()
	}
}