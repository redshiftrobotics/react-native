package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor

@TeleOp(name = "Soccer Bot (main)", group="Linear Opmode")
class KopMode: LinearOpMode() {

	var leftMotor: DcMotor ? = null
	var rightMotor: DcMotor ? = null

	override fun runOpMode() {
		telemetry.addData("initializing...", "")
		telemetry.update()

		leftMotor = hardwareMap.dcMotor.get("left")
		rightMotor = hardwareMap.dcMotor.get("right")

		telemetry.addData("done.", "")
		telemetry.update()

		waitForStart()

		while (opModeIsActive() && leftMotor != null && rightMotor != null) {
			leftMotor!!.power = gamepad1.right_stick_y.toDouble()
			rightMotor!!.power = -gamepad1.left_stick_y.toDouble()
		}
	}

	private fun <T> log (value: T) {
		telemetry.addData("> ", value)
	}
}