package com.example.lesson4_orekhova.data

import android.content.res.Resources
import com.example.lesson4_orekhova.BaseInfoItem
import com.example.lesson4_orekhova.R


fun baseList(resources: Resources): List<BaseInfoItem> {
    return listOf(
        BaseInfoItem(
            name = resources.getString(R.string.item1_base_info),
            image = R.drawable.contacts
        ),
        BaseInfoItem(
            name = resources.getString(R.string.item2_base_info),
            image = R.drawable.zayavki
        ),
        BaseInfoItem(
            name = resources.getString(R.string.item3_base_info),
            image = R.drawable.about
        ),
    )
}
