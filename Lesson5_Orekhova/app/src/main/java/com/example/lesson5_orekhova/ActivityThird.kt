package com.example.lesson5_orekhova

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson5_orekhova.databinding.ActivityThirdBinding
import com.google.android.material.snackbar.Snackbar

class ActivityThird : AppCompatActivity() {
    private val binding by viewBinding(ActivityThirdBinding::bind)
    private val launcher = registerForActivityResult(
        FifthActivityContract()
    ) {
        query ->
        Snackbar.make(binding.root, query, Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        binding.buttonGoTo1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }

        binding.buttonGoTo5.setOnClickListener {
            val intent = Intent(this, ActivityFifth::class.java)
            this.startActivity(intent)
            launcher.launch(Unit)
        }
    }

}