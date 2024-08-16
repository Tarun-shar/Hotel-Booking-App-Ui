package com.example.hotelbookingapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hotelbookingapp.R

class OtpVerificationActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_verification5)
    }

    fun back_arrow(view: View) {
        val intent = Intent(this@OtpVerificationActivity5, SignUpActivity3::class.java)
        startActivity(intent)
        finish()
    }

    fun Verify_btn(view: View) {
        val intent = Intent(this@OtpVerificationActivity5, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}