package com.leandro1995.healthypet.model.entity

import java.io.Serializable

class TypeInjection constructor(val id: Int = -1, val name: String = "") : Serializable {

    fun isId() = id == -1
}