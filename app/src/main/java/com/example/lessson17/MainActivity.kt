package com.example.lessson17

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        val backGround: LinearLayout = findViewById(R.id.backGround)
        val picture: ImageView = findViewById(R.id.picture)
        val textView: TextView = findViewById(R.id.output)

        findViewById<Button>(R.id.plus).setOnClickListener {
            textView.text = "${++count}"
        }
        findViewById<Button>(R.id.minus).setOnClickListener {
            textView.text = "${--count}"
        }
        findViewById<Button>(R.id.zero).setOnClickListener {
            count = 0
            textView.text = "$count"
        }
        findViewById<Button>(R.id.random).setOnClickListener {
            count = Random.nextInt(-100..100)
            textView.text = "$count"
        }
        findViewById<Button>(R.id.red).setOnClickListener {
            textView.setTextColor(Color.RED)
        }
        findViewById<Button>(R.id.green).setOnClickListener {
            textView.setTextColor(Color.GREEN)
        }
        findViewById<Button>(R.id.blue).setOnClickListener {
            textView.setTextColor(Color.BLUE)
        }
        findViewById<Button>(R.id.magenta).setOnClickListener {
            textView.setTextColor(Color.MAGENTA)
        }
        findViewById<Button>(R.id.device).setOnClickListener {
            textView.text = Build.BRAND + " " + Build.MODEL
        }
        findViewById<Button>(R.id.time).setOnClickListener {
            val now = LocalDateTime.now()
            val formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            textView.text = now.format(formatDate)
        }
        findViewById<Button>(R.id.toast).setOnClickListener {
            Toast.makeText(
                this@MainActivity, "Viva Belarus! Glory to Ukraine",
                Toast.LENGTH_SHORT
            ).show()
        }
        findViewById<Button>(R.id.firstBackGround).setOnClickListener {
            backGround.setBackgroundColor(Color.BLUE)
        }
        findViewById<Button>(R.id.secondBackGround).setOnClickListener {
            backGround.setBackgroundColor(Color.YELLOW)
        }
        findViewById<Button>(R.id.thirdBackGround).setOnClickListener {
            backGround.setBackgroundColor(Color.DKGRAY)
        }
        findViewById<Button>(R.id.fourthBackGround).setOnClickListener {
            backGround.setBackgroundColor(Color.CYAN)
        }
        findViewById<Button>(R.id.catButton).setOnClickListener {
            picture.animate().rotation(0F).duration = 500
            picture.setImageResource(R.drawable.cat)
        }
        findViewById<Button>(R.id.dogButton).setOnClickListener {
            picture.animate().rotation(0F).duration = 500
            picture.setImageResource(R.drawable.dog)
        }
        findViewById<Button>(R.id.parrotButton).setOnClickListener {
            picture.animate().rotation(0F).duration = 500
            picture.setImageResource(R.drawable.parrot)
        }
        findViewById<Button>(R.id.rndImage).setOnClickListener {
            picture.animate().rotation(0F).duration = 500
            when (Random.nextInt(1..3)) {
                1 -> picture.setImageResource(R.drawable.cat)
                2 -> picture.setImageResource(R.drawable.dog)
                3 -> picture.setImageResource(R.drawable.parrot)
            }
        }
        // Не удалось реализовать сброс поворота картинки ¯\_(ツ)_/¯
        picture.setOnClickListener {
            when (picture.rotation) {
                0F -> picture.animate().rotation(90f)
                90F -> picture.animate().rotation(180f)
                180F -> picture.animate().rotation(270f)
                270F -> picture.animate().rotation(360f)
                else -> picture.animate().rotation(0f)
            }
        }
    }
}