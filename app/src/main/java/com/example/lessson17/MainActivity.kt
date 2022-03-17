package com.example.lessson17

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.lessson17.databinding.ActivityMainBinding
import java.lang.reflect.Array
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counter = 0

        val imageList = listOf(R.drawable.cat, R.drawable.dog, R.drawable.parrot)

        binding.apply {
            buttonPlus.setOnClickListener {
                counter++
                info.text = counter.toString()
            }

            buttonMinus.setOnClickListener {
                counter--
                info.text = counter.toString()
            }

            buttonZero.setOnClickListener {
                counter = 0
                info.text = counter.toString()
            }

            buttonRandom.setOnClickListener {
                counter = Random.nextInt(-100, 100)
                info.text = counter.toString()
            }

            buttonRed.setOnClickListener {
                info.setTextColor(Color.RED)
            }

            buttonGreen.setOnClickListener {
                info.setTextColor(Color.GREEN)
            }

            buttonBlue.setOnClickListener {
                info.setTextColor(Color.BLUE)
            }

            buttonMagenta.setOnClickListener {
                info.setTextColor(Color.MAGENTA)
            }

            buttonBg1.setOnClickListener {
                activity.setBackgroundColor(Color.GRAY)
            }

            buttonBg2.setOnClickListener {
                activity.setBackgroundColor(Color.YELLOW)
            }

            buttonBg3.setOnClickListener {
                activity.setBackgroundColor(Color.CYAN)
            }

            buttonBg4.setOnClickListener {
                activity.setBackgroundColor(Color.BLUE)
            }

            buttonDevice.setOnClickListener {
                info.text = Build.BRAND + " " + Build.MODEL
            }

            buttonTime.setOnClickListener {
                val now = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("hh:mm")
                info.text = now.format(formatter)

            }

            buttonToast.setOnClickListener {
                Toast.makeText(this@MainActivity, "Hello from Stepan",
                    Toast.LENGTH_SHORT).show()
            }

            buttonCat.setOnClickListener {
                image.rotation = 0F
                image.setImageResource(imageList.get(0))
            }
            buttonDog.setOnClickListener {
                image.rotation = 0F
                image.setImageResource(imageList.get(1))
            }
            buttonParrot.setOnClickListener {
                image.rotation = 0F
                image.setImageResource(imageList.get(2))
            }
            buttonRndAnimal.setOnClickListener {
                var randomDigit = Random.nextInt(100)
                image.rotation = 0F
                when {
                    randomDigit % 2 == 0 -> image.setImageResource(imageList[0])
                    randomDigit % 5 != 0 -> image.setImageResource(imageList[1])
                    randomDigit % 3 == 0 -> image.setImageResource(imageList[2])
                }
            }

            image.setOnClickListener {
                image.rotation = 90F
            }
        }
    }
}