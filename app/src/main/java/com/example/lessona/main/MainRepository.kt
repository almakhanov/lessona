package com.example.lessona.main

import com.example.lessona.Api

class MainRepository(val api: Api){

    fun getPosts() = api.getPosts()

}