package com.example.apicall.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apicall.repository.QuoteRepository
import com.example.apicall.model.UserData

class QuoteViewModel : ViewModel() {

    var quoteLiveData : MutableLiveData<UserData>? =  null

    fun getQuote(): LiveData<UserData>? {
        quoteLiveData = QuoteRepository.getQuoteApiCall()
        return quoteLiveData
    }


}