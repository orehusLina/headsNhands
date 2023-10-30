package com.example.lesson1_orekhova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

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
                var studentText = editTextNameObj.text.toString().trim()
                editTextNameObj.setText("")
                val studentTemp: List<String> = studentText.split(" ")
				var flag = false
				studentTemp.forEach {
					if (it.isEmpty()) {
						flag = true
					}
				}
                if (studentTemp.size != 4 || flag) {
                    val text = "Неправильный ввод"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()

                }
                else {
                    val student = Student(studentTemp[0], studentTemp[1], studentTemp[2], studentTemp[3])
                    val id : Long = System.currentTimeMillis()
                    students[id] = student
                }
                return@setOnKeyListener true
            }
            false
        }

        buttonNameObj.setOnClickListener {
            if (!(textViewNamesObj.text.toString().equals(""))) {
                textViewNamesObj.text = ""
            }

            students.forEach {
                val temp : String = "${it.key} ${it.value.name} ${it.value.surname} " +
                        "${it.value.grade} ${it.value.birthdayYear} \n"

                textViewNamesObj.append(temp);
            }
        }

    }
}