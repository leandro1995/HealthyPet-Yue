package com.leandro1995.healthypet.model.entity

class Injection constructor(
    private val id: Int = -1,
    private val photoUrl: String = "",
    private val currentDate: Long = -1L,
    private val nextAppointment: Long = -1L,
    private val typeInjection: TypeInjection = TypeInjection(),
    private val comment: String = ""
)