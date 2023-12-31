package com.example.lesson1_orekhova

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.TreeSet


class ActivityFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val editTextNames = findViewById<EditText>(R.id.editTextNames)
        val buttonSaveName = findViewById<Button>(R.id.buttonSaveName)
        val buttonListNames = findViewById<Button>(R.id.buttonListNames)
        val textViewNames = findViewById<TextView>(R.id.textViewNamesObj)
        var studentList = TreeSet<String>(); // инициализация списка студентов

        buttonSaveName.setOnClickListener {  // обработка введенного имени
            var studentName = editTextNames.text.toString().trim()
            editTextNames.setText("")
            studentList.add(studentName)
        }

        buttonListNames.setOnClickListener {  // обработка кнопки вывода
            if (!(textViewNames.text.toString().equals(""))) { // очищение поля вывода
                textViewNames.text = ""
            }
            for (student in studentList) {  // вывод студентов
                textViewNames.append(student+"\n");
            }
        }
    }
}