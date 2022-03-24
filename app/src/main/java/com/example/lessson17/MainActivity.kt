package com.example.lessson17

import android.graphics.Color
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.lessson17.databinding.ActivityMainBinding
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var currentImgRes = R.drawable.cat
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



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
                counter = Random.nextInt(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
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
                val currentTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date())
                info.text = currentTime
            }

            buttonToast.setOnClickListener {
                Toast.makeText(this@MainActivity, "Hello from Stepan",
                    Toast.LENGTH_SHORT).show()
            }

            buttonCat.setOnClickListener {
                setImg(image, 0)
            }

            buttonDog.setOnClickListener {
                setImg(image, 1)
            }

            buttonParrot.setOnClickListener {
                setImg(image, 2)
            }

            buttonRndAnimal.setOnClickListener {
                image.rotation = 0F
                val randomImageRes = (IMAGE_LIST - currentImgRes).random()
                currentImgRes = randomImageRes
                image.setImageResource(randomImageRes)
            }

            image.setOnClickListener {
                image.rotation += ROTATION_DEGREES
            }
        }
    }

    private fun setImg(view: View, imgResId: Int){
        val img = (view as ImageView)
        img.rotation = 0F
        currentImgRes = IMAGE_LIST[imgResId]
        img.setImageResource(currentImgRes)

    }

    companion object {
        const val ROTATION_DEGREES = 90F
        val IMAGE_LIST = listOf(R.drawable.cat, R.drawable.dog, R.drawable.parrot)
        const val RANDOM_MIN_VALUE = -100
        const val RANDOM_MAX_VALUE = 100
    }
}