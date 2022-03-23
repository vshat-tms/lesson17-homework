package com.example.lessson17

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0
        var rotation = 0f
        val textView: TextView = findViewById(R.id.myInfo)
        val imageView: ImageView = findViewById(R.id.myImageView)
        val random = Random()

        fun updateRotation(corner: Float){
            rotation = corner
            imageView.rotation = rotation
        }

//      операции со значением счетчика:

        val plus: Button = findViewById(R.id.myPlus)
        plus.setOnClickListener {
            textView.text = "${++counter}"
        }

        val minus: Button = findViewById(R.id.myMinus)
        minus.setOnClickListener {
            textView.text = "${--counter}"
        }

        val zero: Button = findViewById(R.id.myZero)
        zero.setOnClickListener {
            textView.text = 0.toString()
        }

        val rnd: Button = findViewById(R.id.myRND)
        rnd.setOnClickListener {
            val randomNumber = MIN_RND_VALUE + random.nextInt(MAX_RND_VALUE - MIN_RND_VALUE + 1)
            textView.text = randomNumber.toString()
        }

//        изменение цвета счетчика:

        val red: Button = findViewById(R.id.myRed)
        red.setOnClickListener {
            textView.setTextColor(Color.RED)
        }

        val green: Button = findViewById(R.id.myGreen)
        green.setOnClickListener {
            textView.setTextColor(Color.GREEN)
        }

        val blue: Button = findViewById(R.id.myBlue)
        blue.setOnClickListener {
            textView.setTextColor(Color.BLUE)
        }

        val magenta: Button = findViewById(R.id.myMagenta)
        magenta.setOnClickListener {
            textView.setTextColor(Color.MAGENTA)
        }

//        изменение цвета фона:

        val backgroundBlue: Button = findViewById(R.id.myOne)
        backgroundBlue.setOnClickListener {
            findViewById<View>(R.id.background).setBackgroundColor(Color.BLUE)
        }

        val backgroundCyan: Button = findViewById(R.id.myTwo)
        backgroundCyan.setOnClickListener {
            findViewById<View>(R.id.background).setBackgroundColor(Color.CYAN)
        }

        val backgroundYelow: Button = findViewById(R.id.myThree)
        backgroundYelow.setOnClickListener {
            findViewById<View>(R.id.background).setBackgroundColor(Color.YELLOW)
        }

        val backgroundGray: Button = findViewById(R.id.myFour)
        backgroundGray.setOnClickListener {
            findViewById<View>(R.id.background).setBackgroundColor(Color.GRAY)
        }

//      изменение картинки животных:

        val cat: Button = findViewById(R.id.myCat)
        cat.setOnClickListener {
            imageView.setImageResource(R.drawable.cat)
            updateRotation(rotation - rotation)
        }

        val dog: Button = findViewById(R.id.myDog)
        dog.setOnClickListener {
            imageView.setImageResource(R.drawable.dog)
            updateRotation(rotation - rotation)
        }

        val parrot: Button = findViewById(R.id.myParrot)
        parrot.setOnClickListener {
            imageView.setImageResource(R.drawable.parrot)
            updateRotation(rotation - rotation)
        }

        val rndAnimals: Button = findViewById(R.id.myRND_Animals)
        rndAnimals.setOnClickListener {
            val image = arrayOf(R.drawable.cat, R.drawable.dog, R.drawable.parrot)
            imageView.setImageResource(image[random.nextInt(image.size)])
            updateRotation(rotation - rotation)
        }

//        поворот картинки:

        val imageRotation: ImageView = findViewById(R.id.myImageView)
        imageRotation.setOnClickListener {
            updateRotation(rotation + 90)
        }

//        секция инфо:

        val device: Button = findViewById(R.id.myDevice)
        device.setOnClickListener {
            textView.text = "${Build.BRAND} ${Build.MODEL}"
         }

        val time: Button = findViewById(R.id.myTime)
        time.setOnClickListener {
            val currentTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date())
            textView.text = currentTime
        }

        val toast: Button = findViewById(R.id.myToast)
        toast.setOnClickListener {
            Toast.makeText(this, "Нажата кнопка \"toast\"", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val MIN_RND_VALUE = -100
        private const val MAX_RND_VALUE = 100
    }
}