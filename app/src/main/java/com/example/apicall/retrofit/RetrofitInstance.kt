package com.example.apicall.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
            Retrofit.Builder().baseUrl("https://quotable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient())
                .build()
    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}