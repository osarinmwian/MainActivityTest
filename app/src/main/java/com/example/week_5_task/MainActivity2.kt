package com.example.week_5_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import com.example.week_5_task.databinding.ActivityMain2Binding
import com.example.week_5_task.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    val TAG = "MainActivity2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val logoutButton = findViewById<Button>(R.id.button)
        logoutButton.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)//starts intent
        }

    }

    override fun onResume() {
        super.onResume()
        getIntentMessage()
    }

    private fun getIntentMessage() {
        val name = intent.getStringExtra("Full Name")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("phone Number")
        val gender = intent.getStringExtra("Gender")
        binding.textView.apply {
            if (name != null) {
                text = name
                Log.d(TAG, "getIntentMessage:name = $name ")
                Log.d(TAG, "getIntentMessage:nameTv = ${binding.textView.text} ")
            }
        }
        binding.textView2.apply {
            if (email != null) {
                text = email
            }
        }
        binding.textView3.apply {
            if (phone != null) {
                text = phone
                Log.d(TAG, "getIntentMessage:phone = $name ")
                Log.d(TAG, "getIntentMessage:phoneTv = ${binding.textView3.text} ")
            }
            binding.textView.apply {
                if (name != null) {
                    text = name
                }
            }
            binding.textView4.apply {
                if (gender != null) {
                    text = gender
                }
            }
        }
    }
}