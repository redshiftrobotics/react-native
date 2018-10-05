package org.firstinspires.ftc.teamcode

import android.graphics.Bitmap
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import for_camera_opmodes.LinearOpModeCamera
import for_camera_opmodes.OpModeCamera
import java.lang.Exception

@TeleOp(name = "Vision Test", group="Linear Opmode")
class Vision: LinearOpModeCamera() {

	val ds2 = 2

	override fun runOpMode() {
		telemetry.addData("initializing...", "")
		telemetry.update()

		var colorString = "NONE"

		if (isCameraAvailable()) {

			setCameraDownsampling(1)

			telemetry.addLine("Wait for camera to finish initializing!")
			telemetry.update()
			startCamera()

			telemetry.addLine("Camera ready!")
			telemetry.update()

			telemetry.addData("done.", "")
			telemetry.update()

			waitForStart()

			var red = 0
			var green = 0
			var blue = 0

			while (opModeIsActive()) {
				try {
					if (imageReady()) {
						red = 0
						green = 0
						blue = 0
						val rgbImage: Bitmap = convertYuvImageToRgb(yuvImage, width, height, ds2)
						val splitPoint = rgbImage.width / 3

						val width = rgbImage.width - 1 - splitPoint
						for (x in 0..width) {
							for (y in 0..rgbImage.height - 1) {
								val pixel = rgbImage.getPixel(x, y)

								red += red(pixel)
								blue += blue(pixel)
								green += green(pixel)
							} // Y loop
						} // X loop

						log("RAW red: $red, green: $green, blue: $blue")

						red /=      width * rgbImage.height // * 255
						green /=    width * rgbImage.height // * 255
						blue /=     width * rgbImage.height // * 255

						val yellow = (red + green / 2) - blue // TODO: currently this is causing issues because of the unsigned ints

						log("PROCESSED: red: $red, green: $green, blue: $blue, yellow: $yellow, isYellow: ${yellow > 0}")
					} else {
						// TODO:  HANDLE CAMERA NOT READY
					}

					telemetry.update()
					sleep(10)
				} catch (e: Exception) {
					stopCamera()
					log("exception! ${e.message}, ${e.cause}, ${e.stackTrace}")
					telemetry.update()
				}
			}
		}
	}

	private fun <T> log (value: T) {
		telemetry.addData("> ", value)
	}
}