package com.leandro1995.healthypet.model.design

class Calendar constructor(
    val date: Long = -1L,
    val isToday: Boolean = false,
    val isNow: Boolean = false
) {

    fun isDateEmpty() = date == -1L
}