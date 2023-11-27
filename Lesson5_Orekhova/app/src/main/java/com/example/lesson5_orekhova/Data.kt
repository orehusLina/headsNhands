package com.example.lesson5_orekhova

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
class Data (
    val value: String
) : Parcelable { }
