package com.example.lessson17

import android.graphics.Color
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawableWrapper
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0
        val background: LinearLayout = findViewById(R.id.background)
        val textView: TextView = findViewById(R.id.info)
        val image: ImageView = findViewById(R.id.image)

        findViewById<Button>(R.id.buttonPlus).setOnClickListener {
            counter++
            textView.text = "$counter"
        }
        findViewById<Button>(R.id.buttonMinus).setOnClickListener {
            counter--
            textView.text = "$counter"
        }
        findViewById<Button>(R.id.buttonNull).setOnClickListener {
            counter = 0
            textView.text = "$counter"
        }
        findViewById<Button>(R.id.buttonRandom).setOnClickListener {
            counter = (-100..100).random()
            textView.text = "$counter"
        }

        findViewById<Button>(R.id.infoColorRed).setOnClickListener {
            textView.setTextColor(Color.RED)
        }
        findViewById<Button>(R.id.infoColorGreen).setOnClickListener {
            textView.setTextColor(Color.GREEN)
        }
        findViewById<Button>(R.id.infoColorBlue).setOnClickListener {
            textView.setTextColor(Color.BLUE)
        }
        findViewById<Button>(R.id.infoColorMagenta).setOnClickListener {
            textView.setTextColor(Color.MAGENTA)
        }

        findViewById<Button>(R.id.buttonBackgroundColorOne).setOnClickListener {
            background.setBackgroundColor(Color.CYAN)
        }
        findViewById<Button>(R.id.buttonBackgroundColorTwo).setOnClickListener {
            background.setBackgroundColor(Color.LTGRAY)
        }
        findViewById<Button>(R.id.buttonBackgroundColorThree).setOnClickListener {
            background.setBackgroundColor(Color.YELLOW)
        }
        findViewById<Button>(R.id.buttonBackgroundColorFor).setOnClickListener {
            background.setBackgroundColor(Color.DKGRAY)
        }

        findViewById<Button>(R.id.buttonCat).setOnClickListener {
            image.animate().rotation(0f).duration = 500
            image.setImageResource(R.drawable.cat)
        }
        findViewById<Button>(R.id.buttonDog).setOnClickListener {
            image.animate().rotation(0f).duration = 500
            image.setImageResource(R.drawable.dog)
        }
        findViewById<Button>(R.id.buttonParrot).setOnClickListener {
            image.animate().rotation(0f).duration = 500
            image.setImageResource(R.drawable.parrot)
        }
        findViewById<Button>(R.id.buttonImageRandom).setOnClickListener {
            image.animate().rotation(0f).duration = 500
            var numberRandomImage = (1..5).random()
            when (numberRandomImage) {
                1 -> image.setImageResource(R.drawable.cat)
                2 -> image.setImageResource(R.drawable.dog)
                3 -> image.setImageResource(R.drawable.parrot)
                4 -> image.setImageResource(R.drawable.dart_waider)
                5 -> image.setImageResource(R.drawable.hmm)
            }
        }

        image.setOnClickListener {
            when (image.rotation) {
                0F -> image.animate().rotation(90f)
                90F -> image.animate().rotation(180f)
                180F -> image.animate().rotation(270f)
                270F -> image.animate().rotation(360f)
                else -> image.animate().rotation(0f)
            }
        }

        findViewById<Button>(R.id.buttonTime).setOnClickListener {
            textView.text = "${LocalTime.now().hour}:${LocalTime.now().minute}"
        }
        findViewById<Button>(R.id.buttonDevice).setOnClickListener {
            textView.text = "${Build.BRAND} \n ${Build.MODEL}"
        }
        findViewById<Button>(R.id.buttonToast).setOnClickListener {
            val text = "Если надо - то надо, а если не надо - то не надо"
            val toastTime = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext, text, toastTime)
            toast.show()
        }
    }
}