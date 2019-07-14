package com.example.lessona

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_list.*
import java.lang.reflect.Type


class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val sharedPref = getSharedPreferences("MyLocalStorage", Context.MODE_PRIVATE)

        val json = sharedPref.getString(Constants.list, "") ?: ""


        val gson = Gson()
        val type = object : TypeToken<List<User>>() {}.type
        val myList = gson.fromJson(json, type) as ArrayList<User>

        textView.text = myList.toString()

    }


}
