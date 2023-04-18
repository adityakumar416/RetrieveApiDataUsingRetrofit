package com.example.apicall.retrofit

import com.example.apicall.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("quotes")
    fun getData(): Call<UserData>

}