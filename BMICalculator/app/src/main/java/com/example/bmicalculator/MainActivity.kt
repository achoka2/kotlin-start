package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

        lateinit var weightEditText:EditText
        lateinit var heightEditText:EditText
        lateinit var resultText:TextView
        lateinit var imageFigure:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightEditText = findViewById(R.id.weight_edit_input)
        heightEditText =findViewById(R.id.height_edit_input)
        resultText = findViewById(R.id.final_result_text)
        imageFigure = findViewById(R.id.image_for_BMI)

        val calculateButton = findViewById<Button>(R.id.calculate_button)


        calculateButton.setOnClickListener {
            if (weightEditText.text.isNotEmpty() && heightEditText.text.isNotEmpty()) {


                val inputWeight = weightEditText.text.toString().toDouble()
                val inputHeight = heightEditText.text.toString().toDouble()

                val result = inputWeight / (inputHeight * inputHeight)
                resultText.text = result.toString()

                if (result < 18.5) {
                    imageFigure.setImageResource(R.drawable.ic_underweight)
                } else if (result > 18.5 && result < 24.9) {
                    imageFigure.setImageResource(R.drawable.ic_healthy)

                } else if (result > 25 && result < 29.9) {
                    imageFigure.setImageResource(R.drawable.ic_overweight)

                } else {
                    imageFigure.setImageResource(R.drawable.ic_obesity)
                }

            }else{
                Toast.makeText(this,"Enter the needed fields", Toast.LENGTH_SHORT).show()
            }
        }



    }




}