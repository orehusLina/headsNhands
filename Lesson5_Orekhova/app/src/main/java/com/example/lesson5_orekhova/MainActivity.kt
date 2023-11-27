package com.example.lesson5_orekhova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson5_orekhova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.buttonGoTo4.setOnClickListener {
            val timeSeconds : Long = System.currentTimeMillis()
            val intent = Intent(this, ActivityFourth::class.java)
            intent.putExtra("keyTime", timeSeconds)
            this.startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, ActivitySecond::class.java)
            this.startActivity(intent)
        }

    }

}