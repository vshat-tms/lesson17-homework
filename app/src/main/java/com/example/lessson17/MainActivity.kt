package com.example.lessson17

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.plusButton).setOnClickListener{
            findViewById<TextView>(R.id.infoField).text = "${++counter}"
        }

        findViewById<Button>(R.id.minusButton).setOnClickListener{
            findViewById<TextView>(R.id.infoField).text = "${--counter}"
        }

        findViewById<Button>(R.id.randomNumberButton).setOnClickListener{
            counter = Random.nextInt(100)
            findViewById<TextView>(R.id.infoField).text = "$counter"
        }

        findViewById<Button>(R.id.toZeroButton).setOnClickListener{
            counter = 0
            findViewById<TextView>(R.id.infoField).text = "$counter"
        }



        findViewById<Button>(R.id.showDeviceInfoButton).setOnClickListener{
            findViewById<TextView>(R.id.infoField).text = "${Build.BRAND} ${Build.MODEL}"
        }

        findViewById<Button>(R.id.showCurrentTimeButton).setOnClickListener {
            val nowTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                LocalTime.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            findViewById<TextView>(R.id.infoField).text = "$nowTime"
        }

        findViewById<Button>(R.id.toastButton).setOnClickListener{
            val text = "TOAST!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration)
            toast.show()
        }



        findViewById<Button>(R.id.setTextColorRedButton).setOnClickListener{
            findViewById<TextView>(R.id.infoField).setTextColor(Color.parseColor("red"))
        }

        findViewById<Button>(R.id.setTextColorGreenButton).setOnClickListener{
            findViewById<TextView>(R.id.infoField).setTextColor(Color.parseColor("green"))
        }

        findViewById<Button>(R.id.setTextColorBlueButton).setOnClickListener{
            findViewById<TextView>(R.id.infoField).setTextColor(Color.parseColor("blue"))
        }

        findViewById<Button>(R.id.setTextColorMagentaButton).setOnClickListener{
            findViewById<TextView>(R.id.infoField).setTextColor(Color.parseColor("magenta"))
        }



        findViewById<Button>(R.id.setBackgroundColorBlack).setOnClickListener{
            findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.parseColor("Black"))
        }

        findViewById<Button>(R.id.setBackgroundColorYellow).setOnClickListener{
                findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.parseColor("Yellow"))
        }

        findViewById<Button>(R.id.setBackgroundColorGray).setOnClickListener{
            findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.parseColor("Gray"))
        }

        findViewById<Button>(R.id.setBackgroundColorCyan).setOnClickListener {
            findViewById<LinearLayout>(R.id.background).setBackgroundColor(Color.parseColor("Cyan"))
        }



        imageView = findViewById(R.id.image)
        imageView.setOnClickListener { imageView.rotation = 90F }

        findViewById<Button>(R.id.setCatImage).setOnClickListener{
            findViewById<ImageView>(R.id.image).animate().rotation(0F)
            findViewById<ImageView>(R.id.image).setImageResource(R.drawable.cat)
        }

        findViewById<Button>(R.id.setDogImage).setOnClickListener{
            findViewById<ImageView>(R.id.image).animate().rotation(0F)
            findViewById<ImageView>(R.id.image).setImageResource(R.drawable.dog)
        }

        findViewById<Button>(R.id.setParrotImage).setOnClickListener{
            findViewById<ImageView>(R.id.image).animate().rotation(0F)
            findViewById<ImageView>(R.id.image).setImageResource(R.drawable.parrot)
        }

        findViewById<Button>(R.id.setRandomImage).setOnClickListener {
            findViewById<ImageView>(R.id.image).animate().rotation(0F)
            when(Random.nextInt(4)){
                1 -> findViewById<ImageView>(R.id.image).setImageResource(R.drawable.cat)
                2 -> findViewById<ImageView>(R.id.image).setImageResource(R.drawable.dog)
                3 -> findViewById<ImageView>(R.id.image).setImageResource(R.drawable.parrot)
            }
        }




    }
}