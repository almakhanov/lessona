package com.example.lessona

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_form.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FormaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        btnSave.setOnClickListener{
            val post = Post(
                id = 101,
                title = nameEditText.text.toString(),
                body = surnameEditText.text.toString(),
                userId = ageEditText.text.toString().toInt()
            )

            getService().addPost(post).enqueue(object: Callback<Post>{
                override fun onFailure(call: Call<Post>, t: Throwable) {
                    Toast.makeText(this@FormaActivity, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Post>, response: Response<Post>) {
                    Toast.makeText(this@FormaActivity, response.body().toString(), Toast.LENGTH_LONG).show()
                }

            })

            Toast.makeText(this, "Saved!",Toast.LENGTH_SHORT).show()
            finish()
        }

    }


    fun createOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
        return okHttpBuilder.build()
    }


    private fun getService(): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }
}
