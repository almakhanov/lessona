package com.example.lessona.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lessona.FormaActivity
import com.example.lessona.Post
import com.example.lessona.R
import com.example.lessona.UserAdaprer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel


class MainActivity : AppCompatActivity(), UserAdaprer.MyClickListener {

    private var adapter = UserAdaprer()
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = getViewModel()
        adapter.setListener(this)

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter

        viewModel.getPosts()

        fab.setOnClickListener {
            startActivity(Intent(this, FormaActivity::class.java))
        }

        viewModel.postLivaData.observe(this, Observer<List<Post>> {
            adapter.setDataSet(it as ArrayList<Post>)
        })


        viewModel.errorLiveData.observe(this, Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    override fun onClick(item: Post) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()
    }
}