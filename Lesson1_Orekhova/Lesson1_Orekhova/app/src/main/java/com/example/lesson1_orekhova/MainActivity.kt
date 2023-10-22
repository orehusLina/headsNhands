package com.example.lesson1_orekhova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstButton = findViewById<ImageButton>(R.id.firstButton)
        val secondButton = findViewById<ImageButton>(R.id.secondButton)

        firstButton.setOnClickListener {
            val intent = Intent(this, ActivityFirst::class.java)
            startActivity(intent)
        }

        secondButton.setOnClickListener {
            val intent = Intent(this, ActivitySecond::class.java)
            startActivity(intent)
        }
    }
}