package com.leandro1995.healthypet.model.entity

import com.leandro1995.healthypet.database.config.DataBaseConfig

class User {

    suspend fun petArrayList(): ArrayList<Pet> {

        val petArrayList = arrayListOf<Pet>()

        DataBaseConfig.petDao().petList().forEach {

            petArrayList.add(it.pet())
        }

        return petArrayList
    }
}