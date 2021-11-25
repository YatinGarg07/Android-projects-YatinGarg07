package com.example.diceroller

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImg : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button_roll)

        rollButton.setOnClickListener{
            rollDice()
            Toast.makeText(this, "Dice Rolled" , Toast.LENGTH_SHORT).show()



        }
        diceImg = findViewById(R.id.dice_Photo)


    }
    private fun rollDice(){
        val diceText : TextView = findViewById(R.id.text_dice)
       var  diceVal : Int = (1..6).random()
        diceText.text=diceVal.toString()
        changeDiceImage(diceVal)
    }
   private fun changeDiceImage(diceValue : Int){

        val drawableRes = when(diceValue){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5

            else -> R.drawable.dice_6
        }

        diceImg.setImageResource(drawableRes)
    }


}