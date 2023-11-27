package com.example.lesson5_orekhova

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class FifthActivityContract : ActivityResultContract<Unit,String>() {
    override fun createIntent(context: Context, input: Unit): Intent {
        return ActivityFifth.createStartIntent(context)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        return if (resultCode == Activity.RESULT_OK) {
            intent?.getStringExtra(ActivityFifth.KEY_QUERY).orEmpty()
        } else {
            ""
        }
    }
}