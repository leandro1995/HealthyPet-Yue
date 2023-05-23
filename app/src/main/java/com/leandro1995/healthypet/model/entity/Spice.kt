package com.leandro1995.healthypet.model.entity

class Spice constructor(val id: Int = -1, val name: String = "") {

    private fun isIdEmpty() = id == 1
}