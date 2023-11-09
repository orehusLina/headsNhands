package com.example.lesson5_orekhova

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson5_orekhova.databinding.ActivityFifthBinding

class ActivityFifth : AppCompatActivity() {

    private val binding by viewBinding(ActivityFifthBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        binding.buttonDeliverResult.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(KEY_QUERY, binding.editTextMessage.text?.toString().orEmpty())
            })
            finish()
        }
    }

    companion object {
        const val KEY_QUERY = "key_query"

        fun createStartIntent(context: Context): Intent {
            return Intent(context, ActivityThird::class.java)
        }
    }
}