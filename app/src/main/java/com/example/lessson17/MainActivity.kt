package com.example.lessson17

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var linearLayout: LinearLayout
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayTextView = findViewById(R.id.displayTextView)
        imageView = findViewById(R.id.imageView)
        linearLayout = findViewById(R.id.background)
    }

    fun onButtonClick(view: View){
        when(view.id){
            R.id.plusButton -> counterPlusButtonClick()
            R.id.minusButton -> counterMinusButtonClick()
            R.id.randomNumberButton -> counterRandomButtonClick()
            R.id.toZeroButton -> counterToZeroButtonClick()
            R.id.showDeviceInfoButton -> infoShowDeviceModelButton()
            R.id.showCurrentTimeButton -> infoShowTimeButtonClick()
            R.id.toastButton -> infoShowToastButtonClick()
            R.id.setTextColorRedButton -> colorTextSetRedButtonClick()
            R.id.setTextColorGreenButton -> colorTextSetGreenButtonClick()
            R.id.setTextColorBlueButton -> colorTextSetBlueButtonClick()
            R.id.setTextColorMagentaButton -> colorTextSetMagentaButtonClick()
            R.id.setBackgroundColorBlack -> backgroundColorSetBlackButtonClick()
            R.id.setBackgroundColorYellow -> backgroundColorSetYellowButtonClick()
            R.id.setBackgroundColorGray -> backgroundColorSetGrayButtonClick()
            R.id.setBackgroundColorCyan -> backgroundColorSetCyanButtonClick()
            R.id.setCatImage -> imageSetCatButtonClick()
            R.id.setDogImage -> imageSetDogButtonClick()
            R.id.setParrotImage -> imageSetParrotButtonClick()
            R.id.setRandomImage -> imageSetRandomButtonClick()
            R.id.imageView -> imageToRotateButtonClick()
        }
    }

    private fun counterPlusButtonClick(){
        displayTextView.text = "${++counter}"
    }

    private fun counterMinusButtonClick(){
        displayTextView.text = "${--counter}"
    }

    private fun counterRandomButtonClick(){
        counter = Random.nextInt(100)
        displayTextView.text = "$counter"
    }

    private fun counterToZeroButtonClick(){
        counter = 0
        displayTextView.text = "$counter"
    }

    private fun infoShowDeviceModelButton(){
        displayTextView.text = "${Build.MODEL}"
    }

    private fun infoShowTimeButtonClick(){
        displayTextView.text = "$CURRENT_TIME"
    }

    private fun infoShowToastButtonClick(){
        val toast = Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG)
        toast.show()
    }

    private fun colorTextSetRedButtonClick(){
        displayTextView.setTextColor(Color.RED)
    }

    private fun colorTextSetGreenButtonClick(){
        displayTextView.setTextColor(Color.GREEN)
    }

    private fun colorTextSetBlueButtonClick(){
        displayTextView.setTextColor(Color.BLUE)
    }

    private fun colorTextSetMagentaButtonClick(){
        displayTextView.setTextColor(Color.MAGENTA)
    }

    private fun backgroundColorSetBlackButtonClick(){
        linearLayout.setBackgroundColor(Color.BLACK)
    }

    private fun backgroundColorSetYellowButtonClick(){
        linearLayout.setBackgroundColor(Color.YELLOW)
    }

    private fun backgroundColorSetGrayButtonClick(){
        linearLayout.setBackgroundColor(Color.GRAY)
    }

    private fun backgroundColorSetCyanButtonClick(){
        linearLayout.setBackgroundColor(Color.CYAN)
    }

    private fun setDefaultRotationToImage(){
        imageView.rotation = ROTATION_DEGREES.first()
    }

    private fun imageToRotateButtonClick(){
        val currentRotation = imageView.rotation
        val index = ROTATION_DEGREES.indexOf(currentRotation)
        if (currentRotation < ROTATION_DEGREES.last()){
            imageView.rotation = ROTATION_DEGREES[index + 1]
        }else{
            imageView.rotation = ROTATION_DEGREES.first()
        }
    }

    private fun imageSetCatButtonClick(){
        setDefaultRotationToImage()
        imageView.setImageResource(R.drawable.cat)
    }

    private fun imageSetDogButtonClick(){
        setDefaultRotationToImage()
        imageView.setImageResource(R.drawable.dog)
    }

    private fun imageSetParrotButtonClick(){
        setDefaultRotationToImage()
        imageView.setImageResource(R.drawable.parrot)
    }

    private fun imageSetRandomButtonClick(){
        setDefaultRotationToImage()
        imageView.setImageResource(
            PICTURES_ID[Random.nextInt(PICTURES_ID.size)]
        )
    }





    companion object{
        private val DATE_FORMAT = SimpleDateFormat("HH:mm:ss")
        private val CURRENT_TIME: String = DATE_FORMAT.format(Date())
        private const val TOAST_TEXT = "Just message"
        private val ROTATION_DEGREES = listOf(0F, 90F, 180F, 270F)
        private val PICTURES_ID = listOf(R.drawable.cat, R.drawable.dog, R.drawable.parrot)
    }


}