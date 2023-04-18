package com.example.apicall.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apicall.retrofit.RetrofitInstance
import com.example.apicall.model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object QuoteRepository {

    var quote = MutableLiveData<UserData>()

    fun getQuoteApiCall():MutableLiveData<UserData>{

        val call = RetrofitInstance.apiInterface.getData()

        call.enqueue(object : Callback<UserData?> {
            override fun onResponse(call: Call<UserData?>, response: Response<UserData?>) {
                Log.i("error",response.toString())

                val data = response.body()
                if (data != null) {
                    quote.value = UserData(data.count,data.lastItemIndex,data.page,data.results,data.totalCount,data.totalPages)
                }
            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {

                Log.i("error",t.message.toString())
            }
        })
        return quote

    }

}