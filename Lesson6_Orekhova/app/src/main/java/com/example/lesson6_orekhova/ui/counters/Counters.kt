package com.example.lesson6_orekhova.ui.counters

data class Counters(
    val name: String,
    val image: Int,
    val number: Int,
    val submitNumbersDate: String? = null,
    val lastSubmittedDate: String? = null,
    val nextAccountingTime: String? = null,
    val urgent: Boolean,
    val detailInfoNeeded: Boolean? = null,
)