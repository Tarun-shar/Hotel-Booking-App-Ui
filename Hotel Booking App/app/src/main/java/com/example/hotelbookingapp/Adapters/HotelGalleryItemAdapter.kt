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
import com.example.hotelbookingapp.Activity.ShowHotelGalleryImageActivity
import com.example.hotelbookingapp.DataClass.HotelGalleryModel
import com.example.hotelbookingapp.DataClass.HotelModelClass
import com.example.hotelbookingapp.R

class HotelGalleryItemAdapter(private val dataList : ArrayList<HotelGalleryModel>, val context: Context) :RecyclerView.Adapter<HotelGalleryItemAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val hotelGalleryImg:ImageView = view.findViewById(R.id.hotel_galley_img)
        val hotelGalleryCardView:CardView = view.findViewById(R.id.hotel_gallery_card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.hotel_galley_item_file, parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

        Glide.with(context).load(module.hotelGalleryImg).into(holder.hotelGalleryImg)

        holder.hotelGalleryCardView.setOnClickListener {
            val intent = Intent(context, ShowHotelGalleryImageActivity::class.java)
            intent.putExtra("hotelGalImage",module.hotelGalleryImg)
            context.startActivity(intent)
        }

    }
}