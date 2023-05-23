package com.leandro1995.healthypet.model.design

import com.leandro1995.healthypet.config.Setting

class Message constructor(private val indexMessage: Int) {

    fun messageError() = Setting.MESSAGE_HASH_MAP[indexMessage]
}