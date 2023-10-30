package com.example.lesson3_orekhova

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import com.example.lesson3_orekhova.R
import com.example.lesson3_orekhova.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Вышли куда-то", Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.toolbar.menu.findItem(R.id.settings).setOnMenuItemClickListener {
            Toast.makeText(this, "Открыли настройки", Toast.LENGTH_SHORT).show()
            true
        }

        binding.fieldCity.userFieldButton.setOnClickListener{
            Toast.makeText(this, "Питерский карандаш", Toast.LENGTH_SHORT).show()
        }

        binding.buttonLogOut.setOnClickListener{
            Toast.makeText(this, "Вышли из аккаунта", Toast.LENGTH_SHORT).show()

        }

        val worker = Worker(
            "7898769", "Специалист", "Анастасия", "Антонина", "any.box@gmail.com",
            "HIE023UOI88", "Санкт-Петербург"
        )
        val cardText: String = "\nКарта №${worker.card}\n${worker.job}"

        with(binding) {
            textViewCard.text = cardText

            fieldUsername.fieldName.text = getString(R.string.name_title)
            fieldUsername.fieldContent.text = worker.name

            fieldSurename.fieldName.text = getString(R.string.surname_title)
            fieldSurename.fieldContent.text = worker.surname

            fieldEmail.fieldName.text = getString(R.string.email_title)
            fieldEmail.fieldContent.text = worker.email

            fieldLogin.fieldName.text = getString(R.string.login_title)
            fieldLogin.fieldContent.text = worker.login

            fieldCity.fieldName.text = getString(R.string.city_title)
            fieldCity.fieldContent.text = worker.city
            fieldCity.userFieldButton.visibility = VISIBLE
        }
    }
}

