package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton = findViewById<Button>(R.id.search_button)
        val inputField = findViewById<EditText>(R.id.edit_text_search_field)
        val listView = findViewById<ListView>(R.id.list_view)
        val loadMoreButton = findViewById<Button>(R.id.load_more_button)


        //Volley
        searchButton.setOnClickListener {
           val url = getUrl()

            val queue = Volley.newRequestQueue(this)
            val stringRequest = StringRequest(Request.Method.GET, url, { response ->
                extractJSON(response)

            }, { error ->
                error
            })
            queue.add(stringRequest)

    }



    }

    private fun getUrl():String {
        val inputField = findViewById<EditText>(R.id.edit_text_search_field)
        val searchWord = inputField.text
        val apiKey = "5e02af77-eab7-4db5-a7e4-e2a96d3806a8"
        val queue = Volley.newRequestQueue(this)
        val pageNumber = 1
        val pageSize = 10
        return "https://content.guardianapis.com/$searchWord?page=$pageNumber&page-size=$pageSize&api-key=$apiKey"
    }
    private fun extractJSON(response:String){
         val jsonObject = JSONObject(response)
        val jsonResponseBody = jsonObject.getJSONObject("response")
        val results = jsonResponseBody.getJSONArray("results")

        val list = mutableListOf<Data>()

        for(i in 0..9){
            val item = results.getJSONObject(i)
            val webTitle = item.getString("webTitle")
            val webUrl = item.getString("webUrl")

            val data = Data(webTitle, webUrl)
            list.add(data)

        }
    }

}