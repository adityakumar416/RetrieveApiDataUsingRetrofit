package com.example.apicall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.R
import com.example.apicall.model.UserData

class QuotesAdapter:RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {

    private var userData = UserData(0,0,0, emptyList(),0,0)

    class ViewHolder(view : View):RecyclerView.ViewHolder(view) {
        val id : TextView =view.findViewById(R.id.quote_id)
        val quote : TextView =view.findViewById(R.id.quote_name)
        val lastItemIndex : TextView =view.findViewById(R.id.lastItemIndex)
        val page : TextView =view.findViewById(R.id.page)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.quotes_list,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.id.text = (position+1).toString()
        holder.quote.text = userData.results.get(position).content.toString()


    }

    override fun getItemCount(): Int {
        return userData.count
    }

    fun setData(userData: UserData){
        this.userData = userData
        notifyDataSetChanged()
    }
}