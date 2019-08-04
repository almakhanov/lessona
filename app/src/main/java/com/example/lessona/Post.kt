package com.example.lessona

class Post(
    val body: String?,
    var id: String?,
    val title: String?,
    val userId: Int?
){
    constructor() : this("", "", "", 0)
}