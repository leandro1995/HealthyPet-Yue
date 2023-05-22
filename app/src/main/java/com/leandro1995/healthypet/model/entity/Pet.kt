package com.leandro1995.healthypet.model.entity

class Pet constructor(
    private var photoUrl: String = "",
    private var name: String = "",
    private var spice: Spice = Spice(),
    private var isSex: Boolean = false,
    private var date: Long = -1L
)