package com.leandro1995.healthypet.model.design

import java.util.Date

class Calendar constructor(
    val date: Long = -1L,
    val isToday: Boolean = false,
    val isCalendarConstraints: Boolean = false,
    val isNow: Boolean = true
) {
    fun isSelectDay() = isDateEmpty() && !isDateEquals()

    private fun isDateEquals() = date == Date().time

    private fun isDateEmpty() = date == -1L
}