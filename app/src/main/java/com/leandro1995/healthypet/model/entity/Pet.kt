package com.leandro1995.healthypet.model.entity

class Pet constructor(
    var photoUrl: String = "",
    var name: String = "",
    var spice: Spice = Spice(),
    var isSex: Boolean = false,
    var date: Long = -1L
)