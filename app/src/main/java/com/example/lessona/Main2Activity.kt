package com.example.lessona

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        imageView.setOnClickListener{
            onBackPressed()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "msg from activity 2", Toast.LENGTH_SHORT).show()
    }
}
