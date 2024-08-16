package com.example.hotelbookingapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.databinding.ActivityBookingSummaryBinding

class BookingSummary : AppCompatActivity() {

    lateinit var binding: ActivityBookingSummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continueToPaymentBtn.setOnClickListener {
            val intent = Intent(this,PaymentActivity::class.java)
            startActivity(intent)
        }

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}