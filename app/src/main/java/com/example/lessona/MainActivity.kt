package com.example.lessona

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyAdapter.MyClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf<String>("abc", "bcd", "abacaba","abc", "bcd", "abacaba","abc", "bcd", "abacaba","abc", "bcd", "abacaba","abc", "bcd", "abacaba")

        val adapter = MyAdapter()
        adapter.setDataSet(list)
        adapter.setListener(this)

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter
    }


    override fun onClick(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
