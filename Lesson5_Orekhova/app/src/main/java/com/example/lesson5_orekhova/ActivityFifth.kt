package com.example.lesson5_orekhova

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson5_orekhova.databinding.ActivityFifthBinding

class ActivityFifth : AppCompatActivity() {

    private val binding by viewBinding(ActivityFifthBinding::bind)
    private var data: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        binding.buttonDeliverResult.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().apply {
                putExtra(KEY_QUERY, binding.editTextMessage.text?.toString().orEmpty())
            })
            finish()
        }

        binding.buttonSave.setOnClickListener {
            val message = binding.editTextMessageLocal.text?.toString().orEmpty()
            data = Data(message)
            binding.textViewSaved.text = data?.value
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_SAVED_TEXT, data)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        data = savedInstanceState.getParcelable(KEY_SAVED_TEXT)
        binding.textViewSaved.text = data?.value
    }

    companion object {
        const val KEY_QUERY = "key_query"
        const val KEY_SAVED_TEXT = "key_saved_text"

        fun createStartIntent(context: Context): Intent {
            return Intent(context, ActivityFifth::class.java)
        }
    }
}