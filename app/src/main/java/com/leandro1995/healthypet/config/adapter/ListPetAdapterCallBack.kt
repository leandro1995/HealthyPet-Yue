package com.leandro1995.healthypet.config.adapter

import com.leandro1995.healthypet.model.entity.Pet

interface ListPetAdapterCallBack {

    fun pet(pet: Pet)
}