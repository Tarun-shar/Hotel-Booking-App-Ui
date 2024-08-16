package com.example.hotelbookingapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.databinding.ActivitySignUp3Binding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity3 : AppCompatActivity() {

    lateinit var binding: ActivitySignUp3Binding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        val email = binding.emailSignup.text.toString()
        val password = binding.passwordSignup.text.toString()

//        firebaseAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener {
//                if ()
//            }
    }

    fun back_arrow(view: View) {
        val intent = Intent(this@SignUpActivity3, StartActivity2::class.java)
        startActivity(intent)
        finish()
    }

    fun open_login_page(view: View) {
        val intent = Intent(this@SignUpActivity3, LogInActivity4::class.java)
        startActivity(intent)
        finish()
    }

    fun Sign_up_btn(view: View) {

        val intent = Intent(this@SignUpActivity3, OtpVerificationActivity5::class.java)
        startActivity(intent)
        finish()
    }
}