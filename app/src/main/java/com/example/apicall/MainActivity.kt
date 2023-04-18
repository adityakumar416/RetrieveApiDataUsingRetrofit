package com.example.apicall

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apicall.adapter.QuotesAdapter

import com.example.apicall.databinding.ActivityMainBinding
import com.example.apicall.viewModel.QuoteViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quotesViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = QuotesAdapter()
        val recyclerView = binding.recyclerView

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.callApi.setOnClickListener {

            quotesViewModel.getQuote()!!.observe(this, Observer {
                quotes->
                adapter.setData(quotes)
            })

        }


    }


}