package com.example.diceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView



class MainActivity : AppCompatActivity() {

    lateinit var diceOne:ImageView
    lateinit var diceTwo:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceOne = findViewById(R.id.my_dice)
        diceTwo = findViewById((R.id.my_dice2))

        val rollButton = findViewById<Button>(R.id.btn_roll_dice)
        rollButton.setOnClickListener { diceRoller()

        }

    }
    fun diceRoller(){
        val image = when((1..6).random()){
            1->R.drawable.dice1
            2->R.drawable.dice2
            3->R.drawable.dice3
            4->R.drawable.dice4
            5->R.drawable.dice5
            6->R.drawable.dice6
            else->R.drawable.dice_empty

        }

    diceOne.setImageResource(image)
        diceTwo.setImageResource(image)

    }
}