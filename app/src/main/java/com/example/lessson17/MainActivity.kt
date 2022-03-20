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
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*
import com.example.lessson17.MainActivity as MainActivity1

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.myInfo)
        var counter = 0
        val imageView: ImageView = findViewById(R.id.myImageView)
        val random = Random()

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
            textView.text = "${0.also { counter = it }}"
        }

        val rnd: Button = findViewById(R.id.myRND)
        rnd.setOnClickListener {
            val a = -100
            val b = 100
            val randomNumber = a + random.nextInt(b - a + 1)
            textView.text = "${randomNumber.also { counter = randomNumber }}"
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
            val bitmap: Bitmap = (ResourcesCompat.getDrawable(resources, R.drawable.cat, null)
                    as BitmapDrawable).bitmap
            imageView.setImageBitmap(bitmap)
            imageView.setPivotX((imageView.getWidth()/2).toFloat());
            imageView.setPivotY((imageView.getHeight()/2).toFloat());
            imageView.setRotation(0F);
        }

        val dog: Button = findViewById(R.id.myDog)
        dog.setOnClickListener {
            val bitmap: Bitmap = (ResourcesCompat.getDrawable(resources, R.drawable.dog, null)
                    as BitmapDrawable).bitmap
            imageView.setImageBitmap(bitmap)
            imageView.setPivotX((imageView.getWidth()/2).toFloat());
            imageView.setPivotY((imageView.getHeight()/2).toFloat());
            imageView.setRotation(0F);
        }

        val parrot: Button = findViewById(R.id.myParrot)
        parrot.setOnClickListener {
            val bitmap: Bitmap = (ResourcesCompat.getDrawable(resources, R.drawable.parrot, null)
                    as BitmapDrawable).bitmap
            imageView.setImageBitmap(bitmap)
            imageView.setPivotX((imageView.getWidth()/2).toFloat());
            imageView.setPivotY((imageView.getHeight()/2).toFloat());
            imageView.setRotation(0F);

        }

        val rndAnimals: Button = findViewById(R.id.myRND_Animals)
        rndAnimals.setOnClickListener {
            val image = arrayOf(R.drawable.cat, R.drawable.dog, R.drawable.parrot)
            imageView.setImageResource(image[random.nextInt(image.size)])
            imageView.setPivotX((imageView.getWidth()/2).toFloat());
            imageView.setPivotY((imageView.getHeight()/2).toFloat());
            imageView.setRotation(0F);
        }

//        поворот картинки:

        val imageRotation: ImageView = findViewById(R.id.myImageView)
        imageRotation.setOnClickListener {
            imageView.setPivotX((imageView.getWidth()/2).toFloat());
            imageView.setPivotY((imageView.getHeight()/2).toFloat());
            imageView.setRotation(90F);
        }

//        секция инфо:

        val device: Button = findViewById(R.id.myDevice)
        device.setOnClickListener {
            textView.text = "${Build.BRAND} ${Build.MODEL}"
         }

        val time: Button = findViewById(R.id.myTime)
        time.setOnClickListener {
            val time = LocalTime.now()
            val formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
            val formatted = time.format(formatter)
            textView.text = "Сurrent time: $formatted"
        }

        val toast: Button = findViewById(R.id.myToast)
        toast.setOnClickListener {
            val newToast = Toast.makeText(this, "Нажата кнопка \"toast\"", Toast.LENGTH_LONG).show()
        }
    }
}