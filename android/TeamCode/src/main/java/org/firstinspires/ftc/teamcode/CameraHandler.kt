package org.firstinspires.ftc.teamcode

import android.app.Activity
import android.content.Intent
import android.provider.MediaStore
import android.graphics.Bitmap
import android.graphics.SurfaceTexture
import android.hardware.Camera
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.TextureView
import android.view.Gravity
import android.widget.FrameLayout



class CameraHandler {

	private var sender: Vision? = null
	private var activity: Activity? = null
	private var mCamera: Camera? = null

	fun set(sender: Vision) {
		this.sender = sender
		this.activity = sender.hardwareMap.appContext as Activity
	}

	fun takePicture() {
		sender!!.telemetry.addData("", "running...")
		sender!!.telemetry.update()
	}
}