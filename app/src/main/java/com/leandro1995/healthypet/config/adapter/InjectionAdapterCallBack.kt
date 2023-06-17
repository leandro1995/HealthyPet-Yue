package com.leandro1995.healthypet.config.adapter

import com.leandro1995.healthypet.model.entity.Injection

interface InjectionAdapterCallBack {

    fun injection(injection: Injection)
}