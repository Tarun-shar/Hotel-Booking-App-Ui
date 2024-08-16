package com.example.hotelbookingapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelbookingapp.Adapters.HotelGalleryItemAdapter
import com.example.hotelbookingapp.DataClass.HotelGalleryModel
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.databinding.ActivityHotelDetail6Binding

class HotelDetail6 : AppCompatActivity() {

    lateinit var binding: ActivityHotelDetail6Binding
    lateinit var adapterObj: HotelGalleryItemAdapter
    lateinit var dataList: ArrayList<HotelGalleryModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelDetail6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setGalleryImageInRecyclerView()

        binding.bookNowBtn.setOnClickListener {
            val intent = Intent(this, BookingSummary::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setGalleryImageInRecyclerView() {
        dataList = ArrayList()

        dataList.add(HotelGalleryModel(R.drawable.hotel))
        dataList.add(HotelGalleryModel(R.drawable.hot))
        dataList.add(HotelGalleryModel(R.drawable.hotel))
        dataList.add(HotelGalleryModel(R.drawable.hot))

        adapterObj = HotelGalleryItemAdapter(dataList, this)
        binding.hotelGalleryImgRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.hotelGalleryImgRecyclerView.adapter = adapterObj
    }
}