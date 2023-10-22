package com.example.lesson1_orekhova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

open class Student(
    var n : String, var sr : String, var g : String, var by : String
) {

    var name: String = n
        get() = field
        set(value) {
            if (value != "")
                field = value
            else
                throw Exception("Empty name!")
        }
    var surname: String = sr
        get() = field
        set(value) {
            if (value != "")
                field = value
            else
                throw Exception("Empty surname!")
        }

    var grade: String = g
        get() = field
        set(value) {
            if (value != "")
                field = value
            else
                throw Exception("Empty grade!")
        }

    var birthdayYear: String = by
        get() = field
        set(value) {
            if (value.toInt() > 1900 && value.toInt() < 2019 )
                field = value
            else
                throw Exception("Wrong birthday year!")
        }
}

class ActivitySecond : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editTextNameObj = findViewById<EditText>(R.id.editTextNameObj)
        val buttonNameObj = findViewById<Button>(R.id.buttonNameObj)
        val textViewNamesObj = findViewById<TextView>(R.id.textViewNamesObj)
        var students = HashMap<Long, Student>()
        editTextNameObj.setOnKeyListener{_, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                var student = editTextNameObj.text.toString().trim()
                editTextNameObj.setText("")
                var a: List<String> = student.split(" ")
                var person = Student(a[0], a[1], a[2], a[3])
                val id : Long = System.currentTimeMillis()
                students[id] = person
                return@setOnKeyListener true
            }
            false
        }

        buttonNameObj.setOnClickListener {
            if (!(textViewNamesObj.text.toString().equals(""))) {
                textViewNamesObj.text = ""
            }

            for ((id, student) in students) {
                var temp : String = "$id ${student.name} ${student.surname} ${student.grade} ${student.birthdayYear}"
                textViewNamesObj.append(temp+"\n");
            }
        }

    }
}