package com.example.lessona.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lessona.App
import com.example.lessona.Post
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
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

    fun getPostsFromFirebase(){
        App.databaseReference.child("posts").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(dataset: DataSnapshot) {
                val list = arrayListOf<Post>()
                for(item in dataset.children){
                    item.getValue(Post::class.java)?.let{
                        list.add(it)
                    }
                }
                postLivaData.value = list
            }

        })
    }

}