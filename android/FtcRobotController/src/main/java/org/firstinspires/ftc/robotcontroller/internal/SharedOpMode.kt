package org.firstinspires.ftc.robotcontroller.internal

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor

@TeleOp(name = "Shared Op Mode")
class SharedOpMode : LinearOpMode() {

	private val motors = arrayOfNulls<DcMotor>(1024)
	private var motorCount = 0

	var testValue = "TEST"

	override fun runOpMode() {
		sharedOpMode = this
		telemetry.addData("op mode: ", sharedOpMode!!.testValue)
		telemetry.update()

		waitForStart()

		while (opModeIsActive()) continue
	}

	fun getDCMotor(name: String): Int {
		telemetry.addLine("Getting motor with name: $name")
		telemetry.update()
		sleep(2000)

		motors[motorCount] = hardwareMap.dcMotor.get(name)
		motorCount++

		telemetry.addLine("Returning index: ${motorCount - 1}")
		telemetry.update()

		sleep(2000)
		return motorCount - 1
	}

	fun setPower(motorIndex: Int, power: Double) {
		telemetry.addData("Motor index: $motorIndex, power: $power", "")
		telemetry.update()
		motors[motorIndex]!!.power = power
	}
}

