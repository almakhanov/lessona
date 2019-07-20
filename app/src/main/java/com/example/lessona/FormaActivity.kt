package com.example.lessona

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_form.*

class FormaActivity : AppCompatActivity() {

    private var list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val sharedPref = getSharedPreferences("MyLocalStorage", Context.MODE_PRIVATE)
        val json1 = sharedPref.getString(Constants.list, "") ?: ""
        val gson = Gson()
        val type = object : TypeToken<List<User>>() {}.type
        list = gson.fromJson(json1, type) as ArrayList<User>

        btnSave.setOnClickListener{
            val u = User(
                nameEditText.text.toString(),
                surnameEditText.text.toString(),
                ageEditText.text.toString().toInt()
            )
            list.add(u)
            val json = gson.toJson(list)
            sharedPref.edit()
                .putString(Constants.list, json)
                .apply()

            Toast.makeText(this, "Saved!",Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
