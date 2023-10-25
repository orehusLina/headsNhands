package com.example.lesson1_orekhova

open class Student(
    var name : String, var surname : String, var grade : String, var birthdayYear : String
) {

    var Name: String = name
        set(value) {
            if (value != "")
                field = value
            else
                throw Exception("Empty name!")
        }
    var Surname: String = surname
        set(value) {
            if (value != "")
                field = value
            else
                throw Exception("Empty surname!")
        }

    var Grade: String = grade
        set(value) {
            if (value != "")
                field = value
            else
                throw Exception("Empty grade!")
        }

    var birthDayYear: String = birthdayYear
        set(value) {
            if (value.toInt() in 1900 ..2019 )
                field = value
            else
                throw Exception("Wrong birthday year!")
        }
}