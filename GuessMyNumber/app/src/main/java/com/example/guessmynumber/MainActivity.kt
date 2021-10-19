package com.example.guessmynumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var number:Int = 5
    lateinit var questionTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.question_text_view)
        questionTextView.text = String.format(resources.getString(R.string.str_question),number)
    }


    fun clickDownwardArrow(view: View) {

    }


    fun clickSuccess(view: View) {

    }

    fun clickUpwardArrow(view: View) {

    }

    fun clickReset(view: View){}

}