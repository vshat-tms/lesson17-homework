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
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var COUNT = 0

        //findViewById
        val INFO_TABLE = findViewById<TextView>(R.id.info)
        val BACKGROUND = findViewById<LinearLayout>(R.id.background)
        val IMAGE: ImageView = findViewById(R.id.image)

        //PHONE DATA
        val PHONE_MANUFACTURE = Build.MANUFACTURER
        val PHONE_MODEL = Build.MODEL
        val DATE_FORMAT = SimpleDateFormat("HH:mm:ss")

        //TOAST
        val toastText = "Тут могла быть ваша реклама"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, toastText, duration)
        toast.setGravity(Gravity.CENTER, 0, 0)

        findViewById<Button>(R.id.plusCount).setOnClickListener {
            INFO_TABLE.text = "${++COUNT}"
        }
        findViewById<Button>(R.id.minusCount).setOnClickListener {
            INFO_TABLE.text = "${--COUNT}"
        }
        findViewById<Button>(R.id.zeroCount).setOnClickListener {
            COUNT = 0
            INFO_TABLE.text = "$COUNT"
        }
        findViewById<Button>(R.id.randomCount).setOnClickListener {
            COUNT = (-100..100).random()
            INFO_TABLE.text = "$COUNT"
        }
        findViewById<Button>(R.id.device).setOnClickListener {
            INFO_TABLE.text = "$PHONE_MANUFACTURE $PHONE_MODEL"
        }
        findViewById<Button>(R.id.time).setOnClickListener {
            val currentDate = DATE_FORMAT.format(Date())
            INFO_TABLE.text = currentDate
        }
        findViewById<Button>(R.id.toast).setOnClickListener {
            toast.show()
        }
        findViewById<Button>(R.id.colorRed).setOnClickListener {
            INFO_TABLE.setTextColor(Color.parseColor("red"))
        }
        findViewById<Button>(R.id.colorGreen).setOnClickListener {
            INFO_TABLE.setTextColor(Color.parseColor("green"))
        }
        findViewById<Button>(R.id.colorBlue).setOnClickListener {
            INFO_TABLE.setTextColor(Color.parseColor("blue"))
        }
        findViewById<Button>(R.id.colorMagenta).setOnClickListener {
            INFO_TABLE.setTextColor(Color.parseColor("magenta"))
        }
        findViewById<Button>(R.id.firstColorBackground).setOnClickListener {
            BACKGROUND.setBackgroundColor(Color.parseColor("yellow"))
        }
        findViewById<Button>(R.id.secondColorBackground).setOnClickListener {
            BACKGROUND.setBackgroundColor(Color.parseColor("grey"))
        }
        findViewById<Button>(R.id.thirdColorBackground).setOnClickListener {
            BACKGROUND.setBackgroundColor(Color.parseColor("purple"))
        }
        findViewById<Button>(R.id.fourthColorBackground).setOnClickListener {
            BACKGROUND.setBackgroundColor(Color.parseColor("white"))
        }
        IMAGE.setOnClickListener {
            when (IMAGE.rotation) {
                0f -> IMAGE.rotation = 90f
                90f -> IMAGE.rotation = 180f
                180f -> IMAGE.rotation = 270f
                else -> IMAGE.rotation = 0f
            }
        }
        findViewById<Button>(R.id.catImage).setOnClickListener {
            IMAGE.rotation = 0f
            IMAGE.setImageResource(R.drawable.cat)
        }
        findViewById<Button>(R.id.dogImage).setOnClickListener {
            IMAGE.rotation = 0f
            IMAGE.setImageResource(R.drawable.dog)
        }
        findViewById<Button>(R.id.frogImage).setOnClickListener {
            IMAGE.rotation = 0f
            IMAGE.setImageResource(R.drawable.frog)
        }
        findViewById<Button>(R.id.randomImage).setOnClickListener {
            IMAGE.rotation = 0f
            when ((1..3).random()) {
                1 -> IMAGE.setImageResource(R.drawable.cat)
                2 -> IMAGE.setImageResource(R.drawable.dog)
                3 -> IMAGE.setImageResource(R.drawable.frog)
            }
        }
    }
}