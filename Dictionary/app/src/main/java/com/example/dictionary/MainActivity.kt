package com.example.dictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private val message = "WORD_DEFINITION"
    lateinit var editTextWord: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findButton = findViewById<Button>(R.id.find_button)
        editTextWord = findViewById(R.id.word_edit_text)
        val queue = Volley.newRequestQueue(this) //using the volley request library

        findButton.setOnClickListener {

            val word = editTextWord.text  //word that will be inside the edit text
            val apiKey = "b5e27faf-f3db-402d-ada8-a9dcd7b80dfc"
            val url =
                "https://www.dictionaryapi.com/api/v3/references/learners/json/$word?key=$apiKey"
            val stringRequest = StringRequest(Request.Method.GET, url,
                { response ->
                    extractJsonContent(response)
                },
                { error ->
                    error
                }
            )

            queue.add(stringRequest)
        }


    }

    private fun extractJsonContent(response: String) {

        val jsonArray = JSONArray(response)
        val firstIndex = jsonArray.getJSONObject(0)
        val getShortDefinition = firstIndex.getJSONArray("shortdef")
        val firstShortDefinition = getShortDefinition.get(0)

        val intent = Intent(this, WordDefinitionActivity::class.java)
        intent.putExtra(message, firstShortDefinition.toString())
        startActivity(intent)
    }
}