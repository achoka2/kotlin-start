package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var editText:EditText
    var number1:Float = 0.0f
    var isPlus:Boolean = false
    var isMinus:Boolean = false
    var isDivision = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.number_edit_text)
    }

    fun operationFunction(view:View){

        when(view.id){
            R.id.button_one ->{
               numberClicked("1")

            }
            R.id.button_two ->{
                numberClicked("2")

            }
            R.id.button_three ->{
                numberClicked("3")

            }
            R.id.button_four ->{
                numberClicked("4")

            }

            R.id.button_five ->{
                numberClicked("5")

            }
            R.id.button_six ->{
                numberClicked("6")

            }
            R.id.button_seven ->{
                numberClicked("7")

            }
            R.id.button_eight ->{
                numberClicked("8")

            }
            R.id.button_nine ->{
                numberClicked("9")

            }
            R.id.button_zero ->{
                numberClicked("0")

            }
            R.id.button_dot ->{
                numberClicked(".")

            }
            R.id.button_clear->{
                editText.setText("")
            }
            R.id.button_plus->{
                number1 = editText.text.toString().toFloat()
                editText.setText("")
                isPlus = true
            }
            R.id.button_minus->{
                number1= editText.text.toString().toFloat()
                editText.setText("")
                isMinus = true
            }
            R.id.button_division->{
                number1=editText.text.toString().toFloat()
                editText.setText("")
                isDivision = true
            }
            R.id.button_equals-> {

                when {
                    isPlus -> {
                        val number2 = editText.text.toString().toFloat()
                        val result = number1 + number2
                        editText.setText(result.toString())
                        isPlus=false

                    }
                    isMinus -> {
                        val number2 = editText.text.toString().toFloat()
                        val result = number1 - number2
                        editText.setText(result.toString())
                        isMinus = false
                    }
                    isDivision -> {
                        val number2 = editText.text.toString().toFloat()
                        val result = number1 / number2
                        editText.setText(result.toString())
                        isDivision=false

                    }
                }
            }



        }
    }

    fun numberClicked(num:String){
        val number = editText.text.toString()+num
        editText.setText(number)
    }
}