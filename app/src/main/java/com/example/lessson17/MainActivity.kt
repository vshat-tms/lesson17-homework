package com.example.lessson17

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        val infoTable = findViewById<TextView>(R.id.info)
        val background = findViewById<LinearLayout>(R.id.background)
        val image: ImageView = findViewById(R.id.image)

        findViewById<Button>(R.id.plusCount).setOnClickListener {
            infoTable.text = "${++count}"
        }
        findViewById<Button>(R.id.minusCount).setOnClickListener {
            infoTable.text = "${--count}"
        }
        findViewById<Button>(R.id.zeroCount).setOnClickListener {
            count = 0
            infoTable.text = "$count"
        }
        findViewById<Button>(R.id.randomCount).setOnClickListener {
            count = (-100..100).random()
            infoTable.text = "$count"
        }
        findViewById<Button>(R.id.device).setOnClickListener {
            infoTable.text = "$PHONE_MANUFACTURE $PHONE_MODEL"
        }
        findViewById<Button>(R.id.time).setOnClickListener {
            val currentDate = DATE_FORMAT.format(Date())
            infoTable.text = currentDate
        }
        findViewById<Button>(R.id.toast).setOnClickListener {
            val toastText = "Тут могла быть ваша реклама"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(this, toastText, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
        findViewById<Button>(R.id.colorRed).setOnClickListener {
            infoTable.setTextColor(Color.RED)
        }
        findViewById<Button>(R.id.colorGreen).setOnClickListener {
            infoTable.setTextColor(Color.GREEN)
        }
        findViewById<Button>(R.id.colorBlue).setOnClickListener {
            infoTable.setTextColor(Color.BLUE)
        }
        findViewById<Button>(R.id.colorMagenta).setOnClickListener {
            infoTable.setTextColor(Color.MAGENTA)
        }
        findViewById<Button>(R.id.firstColorBackground).setOnClickListener {
            background.setBackgroundColor(Color.YELLOW)
        }
        findViewById<Button>(R.id.secondColorBackground).setOnClickListener {
            background.setBackgroundColor(Color.GRAY)
        }
        findViewById<Button>(R.id.thirdColorBackground).setOnClickListener {
            background.setBackgroundColor(Color.CYAN)
        }
        findViewById<Button>(R.id.fourthColorBackground).setOnClickListener {
            background.setBackgroundColor(Color.WHITE)
        }
        image.setOnClickListener {
            when (image.rotation) {
                0f -> image.rotation = 90f
                90f -> image.rotation = 180f
                180f -> image.rotation = 270f
                else -> image.rotation = 0f
            }
        }
        findViewById<Button>(R.id.catImage).setOnClickListener {
            image.rotation = 0f
            image.setImageResource(R.drawable.cat)
        }
        findViewById<Button>(R.id.dogImage).setOnClickListener {
            image.rotation = 0f
            image.setImageResource(R.drawable.dog)
        }
        findViewById<Button>(R.id.frogImage).setOnClickListener {
            image.rotation = 0f
            image.setImageResource(R.drawable.frog)
        }
        findViewById<Button>(R.id.randomImage).setOnClickListener {
            image.rotation = 0f
            when ((1..3).random()) {
                1 -> image.setImageResource(R.drawable.cat)
                2 -> image.setImageResource(R.drawable.dog)
                3 -> image.setImageResource(R.drawable.frog)
            }
        }
    }

    companion object {
        val PHONE_MANUFACTURE = Build.MANUFACTURER
        val PHONE_MODEL = Build.MODEL
        private val DATE_FORMAT = SimpleDateFormat("HH:mm:ss")
    }
}