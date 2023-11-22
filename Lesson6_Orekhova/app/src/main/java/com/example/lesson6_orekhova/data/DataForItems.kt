package com.example.lesson6_orekhova.data

import android.content.res.Resources
import com.example.lesson6_orekhova.ui.counters.Counters
import com.example.lesson6_orekhova.R

fun listAll(resources: Resources): List<Counters> {
    return listOf(
        Counters(
            name = resources.getString(R.string.cold_water),
            image = R.drawable.ic_water_cold,
            number = 54656553,
            submitNumbersDate = resources.getString(R.string.water_date),
            urgent = true,
        ),
        Counters(
            name = resources.getString(R.string.hot_water),
            image = R.drawable.ic_water_hot,
            number = 54656553,
            submitNumbersDate = resources.getString(R.string.water_date),
            urgent = true,
        ),
        Counters(
            name = resources.getString(R.string.electricity),
            image = R.drawable.ic_electro,
            number = 54656553,
            lastSubmittedDate = "16.02.18",
            nextAccountingTime = "25.02.18",
            urgent = false,
            detailInfoNeeded = true,
        ),
    )
}