package com.example.hotelbookingapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hotelbookingapp.R

class LogInActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in4)
    }

    fun back_arrow(view: View) {
        val intent = Intent(this@LogInActivity4, SignUpActivity3::class.java)
        startActivity(intent)
        finish()
    }

    fun open_signup_page(view: View) {
        val intent = Intent(this@LogInActivity4, SignUpActivity3::class.java)
        startActivity(intent)
        finish()
    }
}