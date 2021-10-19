package com.example.mpesastats

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.FieldPosition

 class MyCustomAdapter( var myArray:ArrayList<String>) : BaseAdapter() {
     override fun getCount(): Int {
         return myArray.size
     }

     override fun getItem(position: Int): Any {
         return myArray[position]
     }

     override fun getItemId(position: Int): Long {
         return position.toLong()
     }

     override fun getView(
         position: Int,
         viewCreator: View?,
         ViewGroup: ViewGroup?
     ): View {

         val context = ViewGroup?.context
         val inflater: LayoutInflater =
             context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

         val rowView = inflater.inflate(R.layout.my_design_layout, ViewGroup, false)

         val item = myArray[position]
         val TranscationTextView = rowView.findViewById<TextView>(R.id.transaction_text_view)
         TranscationTextView.text = item
         return rowView
     }
 }

