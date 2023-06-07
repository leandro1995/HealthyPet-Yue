package com.leandro1995.healthypet.model.design

class Calendar constructor(
    val date: Long = -1L,
    val isToday: Boolean = false,
    val isCalendarConstraints: Boolean = false,
    val isNow: Boolean = true
) {

    fun isDateEmpty() = date == -1L
}