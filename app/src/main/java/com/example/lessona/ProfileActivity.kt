package com.example.lessona

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val sharedPref = getSharedPreferences("MyLocalStorage", Context.MODE_PRIVATE)

        login.text = sharedPref.getString(Constants.keyLogin, "")?.toString()
        password.text = sharedPref.getString(Constants.keyPass, "")?.toString()


        btnNext.setOnClickListener {
            val list = arrayListOf<User>(
                User("qweq", "asd"),
                User("rty", "fghf"),
                User("cvbcv", "zxcz")
            )

            val gson = Gson()
            val json = gson.toJson(list)
            sharedPref.edit()
                .putString(Constants.list, json)
                .apply()

            startActivity(Intent(this, ListActivity::class.java))
        }

    }
}
