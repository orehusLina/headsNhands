package com.example.lesson5_orekhova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson5_orekhova.databinding.ActivityFourthBinding
import com.example.lesson5_orekhova.databinding.ActivitySecondBinding

class ActivitySecond : AppCompatActivity() {

    private val binding by viewBinding(ActivitySecondBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding.buttonGoTo3.setOnClickListener {
            val intent = Intent(this, ActivityThird::class.java)
            this.startActivity(intent)
        }
    }
}