package com.example.lessson17

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var random: Random = Random
    private lateinit var displayTextView: TextView
    private lateinit var imageView: ImageView
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayTextView = findViewById(R.id.displayTextView)
        imageView = findViewById(R.id.imageView)
    }

    fun onButtonClick(view: View) {
        when (view.id) {
            R.id.btn_plus -> plusClick()
            R.id.btn_minus -> minusClick()
            R.id.btn_randomNumber -> randomNumberClick()
            R.id.btn_red -> setRedColorToDisplayText()
            R.id.btn_green -> setGreenColorToDisplayText()
            R.id.btn_blue -> setBlueColorToDisplayText()
            R.id.btn_magenta -> setMagentaColorToDisplayText()
            R.id.btn_redBackground -> setRedBackgroundColor()
            R.id.btn_greenBackground -> setGreenBackgroundColor()
            R.id.btn_blueBackground -> setBlueBackgroundColor()
            R.id.btn_magentaBackground -> setMagentaBackgroundColor()
            R.id.btn_cat -> setCatImage()
            R.id.btn_dog -> setDogImage()
            R.id.btn_parrot -> setParrotImage()
            R.id.imageView -> rotateImage()
            R.id.btn_randomImage -> setRandomImage()
            R.id.btn_device -> showDeviceModel()
            R.id.btn_time -> showCurrentTime()
            R.id.btn_toast -> showToast()
        }
    }

    private fun showToast() {
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, TOAST_TEXT, duration)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    private fun showCurrentTime() {
        val currentTime = DATE_FORMAT.format(Date())
        displayTextView.text = currentTime
    }

    private fun showDeviceModel() {
        displayTextView.text = "${Build.MODEL}"
    }

    private fun setRandomImage() {
        setDefaultRotation()
        imageView.setImageResource(
            PICTURES_ID[random.nextInt(PICTURES_ID.size)]
        )
    }

    private fun rotateImage() {
        val currentDegree = imageView.rotation
        val index = ROTATION_DEGREES.indexOf(currentDegree)
        if (currentDegree < ROTATION_DEGREES.last()) {
            imageView.rotation = ROTATION_DEGREES[index + 1]
        } else {
            imageView.rotation = ROTATION_DEGREES.first()
        }
    }

    private fun setDefaultRotation() {
        imageView.rotation = ROTATION_DEGREES.first()
    }

    private fun setParrotImage() {
        setDefaultRotation()
        imageView.setImageResource(R.drawable.parrot)
    }

    private fun setDogImage() {
        setDefaultRotation()
        imageView.setImageResource(R.drawable.dog)
    }

    private fun setCatImage() {
        setDefaultRotation()
        imageView.setImageResource(R.drawable.cat)
    }

    private fun setMagentaBackgroundColor() {
        findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.MAGENTA)
    }

    private fun setBlueBackgroundColor() {
        findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.BLUE)
    }

    private fun setGreenBackgroundColor() {
        findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.GREEN)
    }

    private fun setRedBackgroundColor() {
        findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.RED)
    }

    private fun setRedColorToDisplayText() {
        displayTextView.setTextColor(Color.RED)
    }

    private fun setGreenColorToDisplayText() {
        displayTextView.setTextColor(Color.GREEN)
    }

    private fun setBlueColorToDisplayText() {
        displayTextView.setTextColor(Color.BLUE)
    }

    private fun setMagentaColorToDisplayText() {
        displayTextView.setTextColor(Color.MAGENTA)
    }

    private fun minusClick() {
        displayTextView.text = "${--counter}"
    }

    private fun plusClick() {
        displayTextView.text = "${++counter}"
    }

    private fun randomNumberClick() {
        displayTextView.text = "${random.nextInt(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)}"
    }

    companion object {
        private const val TOAST_TEXT = "Hello from VoVoZoZo"
        private val DATE_FORMAT = SimpleDateFormat("HH:mm:ss")
        private const val RANDOM_MIN_VALUE = -100
        private const val RANDOM_MAX_VALUE = 100
        private val ROTATION_DEGREES = listOf(0F, 90F, 180F, 270F)
        private val PICTURES_ID = listOf(
            R.drawable.cat, R.drawable.dog, R.drawable.parrot,
            R.drawable.cat2, R.drawable.dog2
        )
    }
}