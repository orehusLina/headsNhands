package com.example.lesson4_orekhova.data

import android.content.res.Resources
import com.example.lesson4_orekhova.DetailInfoItem
import com.example.lesson4_orekhova.R

fun detailList(resources: Resources): List<DetailInfoItem> {
    return listOf(
        DetailInfoItem(
            name = resources.getString(R.string.item1_name),
            description = resources.getString(R.string.item1_description),
            image = R.drawable.kvitochki,
            urgent = true,
        ),
        DetailInfoItem(
            name = resources.getString(R.string.item2_name),
            description = resources.getString(R.string.item2_description),
            image = R.drawable.schetchik,
            urgent = true,
        ),
        DetailInfoItem(
            name = resources.getString(R.string.item3_name),
            description = resources.getString(R.string.item3_description),
            image = R.drawable.rassrochka,
            urgent = false,
        ),
        DetailInfoItem(
            name = resources.getString(R.string.item4_name),
            description = resources.getString(R.string.item4_description),
            image = R.drawable.strakhovanie,
            urgent = false,
        ),
        DetailInfoItem(
            name = resources.getString(R.string.item5_name),
            description = resources.getString(R.string.item5_description),
            image = R.drawable.internet,
            urgent = false,
        ),
        DetailInfoItem(
            name = resources.getString(R.string.item6_name),
            description = resources.getString(R.string.item6_description),
            image = R.drawable.domophone,
            urgent = false,
        ),
        DetailInfoItem(
            name = resources.getString(R.string.item7_name),
            description = resources.getString(R.string.item7_description),
            image = R.drawable.ohrana,
            urgent = false,
        )
    )
}

