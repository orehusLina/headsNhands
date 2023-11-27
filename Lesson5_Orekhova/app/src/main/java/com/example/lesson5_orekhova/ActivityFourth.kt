package com.example.lesson5_orekhova

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson5_orekhova.databinding.ActivityFourthBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

class ActivityFourth : AppCompatActivity() {
    private val binding by viewBinding(ActivityFourthBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        showTime(intent)

        binding.buttonGoTo4Again.setOnClickListener {
            val timeSeconds : Long = System.currentTimeMillis()
            val intent = Intent(this, ActivityFourth::class.java)
            intent.putExtra("keyTime", timeSeconds)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        showTime(intent)
    }

    private fun showTime(intent: Intent) {
        var timeSeconds : Long = 0
        timeSeconds = intent.getLongExtra("keyTime", timeSeconds)
        val date = Date(timeSeconds)
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
        sdf.timeZone = TimeZone.getTimeZone("UTC+4")
        val formattedDate: String = sdf.format(date)
        binding.textViewForTime.text = formattedDate
    }
}