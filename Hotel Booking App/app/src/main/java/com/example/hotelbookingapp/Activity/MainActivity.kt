package com.example.hotelbookingapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hotelbookingapp.Fragments.HomeFragment
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        setCurrentFragment(homeFragment)

        binding.bottomNaviBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.favorites -> {
                    Toast.makeText(this@MainActivity, "Favorites", Toast.LENGTH_SHORT).show()
                }
                R.id.my_bookings -> {
                    Toast.makeText(this@MainActivity, "My Bookings", Toast.LENGTH_SHORT).show()
                }
                R.id.chats -> {
                    Toast.makeText(this@MainActivity, "Chats", Toast.LENGTH_SHORT).show()
                }
                R.id.profile -> {
                    Toast.makeText(this@MainActivity, "Profile", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }
}