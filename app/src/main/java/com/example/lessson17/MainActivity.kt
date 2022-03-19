package com.example.lessson17

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.plusButton).setOnClickListener{
            findViewById<TextView>(R.id.screen).text="${count++}"
        }
        findViewById<Button>(R.id.minusButton).setOnClickListener{
            findViewById<TextView>(R.id.screen).text="${count--}"
        }
        findViewById<Button>(R.id.zeroButton).setOnClickListener{
            var zero : Int = 0
            count = zero
            findViewById<TextView>(R.id.screen).text= "$count"
        }
        findViewById<Button>(R.id.randomButton).setOnClickListener{
            val random : Int = Random.nextInt(-100,100)
            findViewById<TextView>(R.id.screen).text="$random"
        }
        findViewById<Button>(R.id.rColorButton).setOnClickListener{
            findViewById<TextView>(R.id.screen).setTextColor(Color.parseColor("red"))
        }
        findViewById<Button>(R.id.gColorButton).setOnClickListener{
            findViewById<TextView>(R.id.screen).setTextColor(Color.parseColor("green"))
        }
        findViewById<Button>(R.id.bColorButton).setOnClickListener{
            findViewById<TextView>(R.id.screen).setTextColor(Color.parseColor("blue"))
        }
        findViewById<Button>(R.id.mColorButton).setOnClickListener{
            findViewById<TextView>(R.id.screen).setTextColor(Color.parseColor("magenta"))
        }
        findViewById<Button>(R.id.oneBackgroundButton).setOnClickListener{
            findViewById<LinearLayout>(R.id.background).setBackgroundResource(R.drawable.ground)
        }
        findViewById<Button>(R.id.twoBackgroundButton).setOnClickListener{
            findViewById<LinearLayout>(R.id.background).setBackgroundResource(R.drawable.ground2)
        }
        findViewById<Button>(R.id.threeBackgroundButton).setOnClickListener{
            findViewById<LinearLayout>(R.id.background).setBackgroundResource(R.drawable.ground3)
        }
        findViewById<Button>(R.id.fourBackgroundButton).setOnClickListener{
            findViewById<LinearLayout>(R.id.background).setBackgroundResource(R.drawable.ground4)
        }
        findViewById<Button>(R.id.catButton).setOnClickListener{
            findViewById<ImageView>(R.id.picture).animate().rotation(0F)
            findViewById<ImageView>(R.id.picture).setImageResource(R.drawable.cat)
        }
        findViewById<Button>(R.id.dogButton).setOnClickListener{
            findViewById<ImageView>(R.id.picture).animate().rotation(0F)
            findViewById<ImageView>(R.id.picture).setImageResource(R.drawable.dog)
        }
        findViewById<Button>(R.id.parrotButton).setOnClickListener{
            findViewById<ImageView>(R.id.picture).animate().rotation(0F)
            findViewById<ImageView>(R.id.picture).setImageResource(R.drawable.parrot)
        }
        findViewById<Button>(R.id.randomPictureButton).setOnClickListener{
            findViewById<ImageView>(R.id.picture).animate().rotation(0F)
            when(Random.nextInt(1,4)){
                1 -> findViewById<ImageView>(R.id.picture).setImageResource(R.drawable.cat)
                2 -> findViewById<ImageView>(R.id.picture).setImageResource(R.drawable.dog)
                3 -> findViewById<ImageView>(R.id.picture).setImageResource(R.drawable.parrot)
            }
        }
        findViewById<ImageView>(R.id.picture).setOnClickListener{
            findViewById<ImageView>(R.id.picture).animate().rotation(90F).duration = 3000
        }
        findViewById<Button>(R.id.deviceButton).setOnClickListener{
            findViewById<TextView>(R.id.screen).text = "${Build.BRAND} ${Build.DISPLAY}"
        }
        findViewById<Button>(R.id.timeButton).setOnClickListener{
            val nowTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                LocalTime.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            findViewById<TextView>(R.id.screen).text = "$nowTime"
        }
        findViewById<Button>(R.id.toastButton).setOnClickListener{
            val text = "You entered button TOAST!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration)
            toast.show()
        }
    }
}