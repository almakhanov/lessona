package com.example.lessona

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @POST("posts")
    fun addPost(@Body post: Post): Call<Post>


}