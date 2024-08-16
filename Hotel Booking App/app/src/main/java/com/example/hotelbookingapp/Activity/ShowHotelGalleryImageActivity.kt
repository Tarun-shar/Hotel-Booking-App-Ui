package com.example.hotelbookingapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.databinding.ActivityShowHotelGalleryImageBinding

class ShowHotelGalleryImageActivity : AppCompatActivity() {

    lateinit var binding: ActivityShowHotelGalleryImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowHotelGalleryImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val hotelGalImg = intent.getStringExtra("hotelGalImg")

        Glide.with(this).load(hotelGalImg).into(binding.hotelGalImageShow)
    }
}