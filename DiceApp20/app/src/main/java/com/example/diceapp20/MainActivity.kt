package com.example.diceapp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonRoll = findViewById<Button>(R.id.button_Roll)
        val image = findViewById<ImageView>(R.id.dice_empty)


        buttonRoll.setOnClickListener{
            val randomNum:Int = (1..6).random()

           val diceImage = when(randomNum){
                1->R.drawable.dice1
                2->R.drawable.dice2
                3->R.drawable.dice3
                4->R.drawable.dice4
                5->R.drawable.dice5
                6->R.drawable.dice6
                else->R.drawable.dice_empty
            }
            image.setImageResource(diceImage)
        }

    }



}