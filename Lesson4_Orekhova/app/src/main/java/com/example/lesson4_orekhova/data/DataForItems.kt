package com.example.lesson4_orekhova.data

import android.content.res.Resources
import com.example.lesson4_orekhova.BaseInfoItem
import com.example.lesson4_orekhova.DetailInfoItem
import com.example.lesson4_orekhova.ListItem
import com.example.lesson4_orekhova.R

fun listAll(resources: Resources): List<ListItem> {
    return listOf(
        ListItem.DetailItem(
            DetailInfoItem(
                name = "Квитанции",
                description = "- 40 080,55 ₽",
                image = R.drawable.kvitochki,
                urgent = true,
            )
        ),
        ListItem.DetailItem(
            DetailInfoItem(
                name = "Счетчики",
                description = "Подайте показания",
                image = R.drawable.schetchik,
                urgent = true,
            )
        ),
        ListItem.DetailItem(
            DetailInfoItem(
                name = "Рассрочка",
                description = "Сл. платеж 25.02.2018",
                image = R.drawable.rassrochka,
                urgent = false,
            )
        ),
        ListItem.DetailItem(
            DetailInfoItem(
                name = "Страхование",
                description = "Полис до 12.01.2019",
                image = R.drawable.strakhovanie,
                urgent = false,
            )
        ),
        ListItem.DetailItem(
            DetailInfoItem(
                name = "Интернет и ТВ",
                description = "Баланс 350 ₽",
                image = R.drawable.internet,
                urgent = false,
            )
        ),
        ListItem.DetailItem(
            DetailInfoItem(
                name = "Домофон",
                description = "Подключен",
                image = R.drawable.domophone,
                urgent = false,
            )
        ),
        ListItem.BaseItem(
            BaseInfoItem(
                name = "Охрана",
                description = "Нет",
                image = R.drawable.ohrana,
            )
        ),
        ListItem.BaseItem(
            BaseInfoItem(
                name = "Контакты УК и служб",
                image = R.drawable.contacts
            )
        ),
        ListItem.BaseItem(
            BaseInfoItem(
                name = "Мои заявки",
                image = R.drawable.zayavki
            )
        ),
        ListItem.BaseItem(
            BaseInfoItem(
                name = "Памятка жителя A101",
                image = R.drawable.about
            )
        ),
    )
}
