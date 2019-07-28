package com.example.lessona.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessona.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(val respository: MainRepository): ViewModel(){

    val postLivaData = MutableLiveData<List<Post>>()
    val errorLiveData = MutableLiveData<String>()


    fun getPosts() {
        respository.getPosts().enqueue(object: Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                errorLiveData.value = t.localizedMessage
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postLivaData.value = response.body()
            }
        })
    }

}