package com.example.lessona

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("MyLocalStorage", Context.MODE_PRIVATE)

        saveBtn.setOnClickListener{

            sharedPref.edit()
                .putString(Constants.keyLogin, login.text.toString())
                .putString(Constants.keyPass, password.text.toString())
                .apply()

            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
