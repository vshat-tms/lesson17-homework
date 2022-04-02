package com.example.lessson17

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.DateFormat
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        val screenTable = findViewById<TextView>(R.id.screen)
        val background = findViewById<LinearLayout>(R.id.background)
        val image = findViewById<ImageView>(R.id.picture)

        findViewById<Button>(R.id.plusButton).setOnClickListener {
            screenTable.text = "${count++}"
        }
        findViewById<Button>(R.id.minusButton).setOnClickListener {
            screenTable.text = "${count--}"
        }
        findViewById<Button>(R.id.zeroButton).setOnClickListener {
            count = 0
            screenTable.text = "$count"
        }
        findViewById<Button>(R.id.randomButton).setOnClickListener {
            val random = Random.nextInt(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
            screenTable.text = "$random"
        }
        findViewById<Button>(R.id.rColorButton).setOnClickListener {
            screenTable.setTextColor(Color.parseColor("red"))
        }
        findViewById<Button>(R.id.gColorButton).setOnClickListener {
            screenTable.setTextColor(Color.parseColor("green"))
        }
        findViewById<Button>(R.id.bColorButton).setOnClickListener {
            screenTable.setTextColor(Color.parseColor("blue"))
        }
        findViewById<Button>(R.id.mColorButton).setOnClickListener {
            screenTable.setTextColor(Color.parseColor("magenta"))
        }
        findViewById<Button>(R.id.oneBackgroundButton).setOnClickListener {
            background.setBackgroundResource(R.drawable.ground)
        }
        findViewById<Button>(R.id.twoBackgroundButton).setOnClickListener {
            background.setBackgroundResource(R.drawable.ground2)
        }
        findViewById<Button>(R.id.threeBackgroundButton).setOnClickListener {
            background.setBackgroundResource(R.drawable.ground3)
        }
        findViewById<Button>(R.id.fourBackgroundButton).setOnClickListener {
            background.setBackgroundResource(R.drawable.ground4)
        }
        findViewById<Button>(R.id.catButton).setOnClickListener {
            image.animate().rotation(0F)
            image.setImageResource(R.drawable.cat)
        }
        findViewById<Button>(R.id.dogButton).setOnClickListener {
            image.animate().rotation(0F)
            image.setImageResource(R.drawable.dog)
        }
        findViewById<Button>(R.id.parrotButton).setOnClickListener {
            image.animate().rotation(0F)
            image.setImageResource(R.drawable.parrot)
        }
        findViewById<Button>(R.id.randomPictureButton).setOnClickListener {
            image.animate().rotation(0F)
            when (Random.nextInt(1, 4)) {
                1 -> image.setImageResource(R.drawable.cat)
                2 -> image.setImageResource(R.drawable.dog)
                3 -> image.setImageResource(R.drawable.parrot)
            }
        }
        findViewById<Button>(R.id.deviceButton).setOnClickListener {
            screenTable.text = "${Build.BRAND} ${Build.DISPLAY}"
        }
        findViewById<Button>(R.id.timeButton).setOnClickListener {
            screenTable.text = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date())
        }
        findViewById<Button>(R.id.toastButton).setOnClickListener {
            val text = "You entered button TOAST!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(this, text, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
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
    }

    companion object {
        private const val RANDOM_MIN_VALUE = -100
        private const val RANDOM_MAX_VALUE = 100
    }
}