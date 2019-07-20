package com.example.lessona

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), UserAdaprer.MyClickListener {

    lateinit var list: List<User>
    private val gson = Gson()
    private var adapter = UserAdaprer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter.setListener(this)

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter

        updateData()

        fab.setOnClickListener {
            startActivity(Intent(this, FormaActivity::class.java))
        }
    }

    override fun onRestart() {
        super.onRestart()
        updateData()
        Toast.makeText(this, "list updated", Toast.LENGTH_SHORT).show()
    }

    private fun updateData(){
        val sharedPref = getSharedPreferences("MyLocalStorage", Context.MODE_PRIVATE)
        val json = sharedPref.getString(Constants.list, "") ?: ""
        val type = object : TypeToken<List<User>>() {}.type
        list = gson.fromJson(json, type) as ArrayList<User>
        adapter.setDataSet(list as ArrayList<User>)
    }


    override fun onClick(item: User) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()
    }
}