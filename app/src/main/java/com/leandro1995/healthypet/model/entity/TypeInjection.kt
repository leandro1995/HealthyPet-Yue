package com.leandro1995.healthypet.model.entity

class TypeInjection constructor(val id: Int = -1, val name: String = "") {

    fun isId() = id == -1
}