package com.example.hotelbookingapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelbookingapp.Activity.HotelDetail6
import com.example.hotelbookingapp.DataClass.HotelModelClass
import com.example.hotelbookingapp.R

class HotelItemAdapter(private val dataList : ArrayList<HotelModelClass>, val context: Context) :RecyclerView.Adapter<HotelItemAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var hotelImg:ImageView = view.findViewById(R.id.hotel_img)
        var hotelName:TextView = view.findViewById(R.id.hotel_name)
        var hotelRate:TextView = view.findViewById(R.id.hotel_rate)
        val card_view:CardView = view.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.hotel_item_file, parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

        holder.hotelName.text = module.name
        holder.hotelRate.text = module.rate
        Glide.with(context).load(module.hotelImg).into(holder.hotelImg)

        holder.card_view.setOnClickListener {
            val intent = Intent(context, HotelDetail6::class.java)
            context.startActivity(intent)
        }
    }
}