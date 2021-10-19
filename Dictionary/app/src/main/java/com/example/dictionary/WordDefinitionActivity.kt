package com.example.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ImageView

class WordDefinitionActivity : AppCompatActivity() {
    private val message = "WORD_DEFINITION"
    lateinit var backArrow: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_definition)

        val definitionDisplay = findViewById<TextView>(R.id.definition_text_view)

        definitionDisplay.text = intent.getStringExtra(message)

        backArrow = findViewById(R.id.back_image_view)

       backArrow.setOnClickListener {
            finish()
        }


    }
}