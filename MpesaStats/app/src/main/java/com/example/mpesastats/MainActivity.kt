package com.example.mpesastats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InflateException
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myListView = findViewById<ListView>(R.id.List_view)


        val myArray = arrayListOf<String>("Achoka","James","Cliford")

        val customAdapter:MyCustomAdapter = MyCustomAdapter(myArray)

        myListView.adapter = customAdapter
    }


    }
