package com.example.lesson4_orekhova

sealed class ListItem {

    data class DetailItem(val detailItem: DetailInfoItem) : ListItem()

    data class BaseItem(val baseItem: BaseInfoItem) : ListItem()
}