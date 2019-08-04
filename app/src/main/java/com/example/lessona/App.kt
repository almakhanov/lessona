package com.example.lessona

import android.app.Application
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.koin.android.ext.android.startKoin

class App: Application(){

    companion object {
        lateinit var databaseReference : DatabaseReference
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this,listOf(appModule))
        databaseReference = FirebaseDatabase.getInstance().reference
    }

}