package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.bosch.BNO055IMU
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference
import org.firstinspires.ftc.robotcore.external.navigation.Orientation
import java.lang.Math.abs
import java.lang.Math.pow
import java.text.FieldPosition
import kotlin.math.roundToInt

class Config {

	companion object {

		val pTuning: Double = 0.1
		val iTuning: Double = 0.1
		val dTuning: Double = 0.1
		val  target: Double = 0.0
	}
}

@Autonomous(name = "PID", group = "Pre - Season")
class PID: LinearOpMode() {

	// MARK - PID stuff

	var       p: Double = 0.0
	var       i: Double = 0.0
	var       d: Double = 0.0
	var lastErr: Double = 0.0

	// MARK - IMU

	var        imu: BNO055IMU?   = null
	var      angle: Float        = 0.0f
	var  leftMotor: DcMotor?     = null
	var rightMotor: DcMotor ?    = null

	fun process(position: Double): Double {

		val error = Config.target - position
		p = error
		i += error
		d = error - lastErr

		return  Config.pTuning * p +
				Config.iTuning * i +
				Config.dTuning * d
	}

	override fun runOpMode() {
		var parameters                 = BNO055IMU.Parameters()
		parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES
		parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC
		parameters.calibrationDataFile = "BNO055IMUCalibration.json"
		parameters.loggingEnabled      = true
		parameters.loggingTag          = "IMU"
		parameters.accelerationIntegrationAlgorithm = JustLoggingAccelerationIntegrator()

		imu = hardwareMap.get(BNO055IMU::class.java, "imu")
		imu!!.initialize(parameters).also { log("Initializing...", update = true) }

		leftMotor = hardwareMap.dcMotor.get("left_drive")
		rightMotor = hardwareMap.dcMotor.get("right_drive").also { log("Done.", update = true) }

		waitForStart()

		while (opModeIsActive()
			&& imu          != null
			&& leftMotor    != null
			&& rightMotor   != null) {

			angle = imu!!.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle

			log("angles = $angle")

			// move forward
			// ...

			sleep(1000)

			// turn 90º
			while (angle / 360f < 90 && opModeIsActive()) {
				val power = ((process((angle / 360f).toDouble()) * 1000).roundToInt() / 1000).toDouble().also { log(it) }

				if (power > 0) {
					leftMotor!!.power = (-power * 2) + 0.5
					rightMotor!!.power = (power * 2) + 0.5
				} else {
					leftMotor!!.power = (power * 2) + 0.5
					rightMotor!!.power = (-power * 2) + 0.5
				}

				log("${angle}° -> ${power}° -> ${Config.target}°", update = true)
			}
		}

		telemetry.update()
	}

	// fun test () {

	// 	var test: Double = (0..360).shuffled().last() as Double
	// 	val diff: Int = abs((test - Config.target) as Int

	// 	for (index in 0..diff) {
	// 		val foo = process(pos / 360)

	//		print("$test° -> ${Config.target}°")
	//	}
	//}

	private fun <T> log (value: T, update: Boolean = false) {
		telemetry.addData("> ", value)
		if (update) {
			telemetry.update()
		}
	}
}
