package com.leandro1995.healthypet.component.config.callback

import com.leandro1995.healthypet.model.entity.Pet

interface PetListComponentCallBack {

    fun pet(pet: Pet)
}