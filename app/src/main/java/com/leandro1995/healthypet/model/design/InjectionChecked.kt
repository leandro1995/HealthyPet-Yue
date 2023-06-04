package com.leandro1995.healthypet.model.design

import com.leandro1995.healthypet.model.entity.Injection

class InjectionChecked constructor(
    val injection: Injection,
    var isChecked: Boolean = false
)