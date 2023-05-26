package com.leandro1995.healthypet.component

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import com.leandro1995.healthypet.adapter.ListPetAdapter
import com.leandro1995.healthypet.component.ambient.ListViewAmbient
import com.leandro1995.healthypet.component.config.ComponentSetting
import com.leandro1995.healthypet.model.entity.Pet

class PetListComponent(context: Context, attrs: AttributeSet? = null) :
    ListViewAmbient(context, attrs) {

    private lateinit var listPetAdapter: ListPetAdapter

    private val petArrayList = arrayListOf<Pet>()

    fun petArrayList(petArrayList: ArrayList<Pet>) {

        this.petArrayList.clear()
        this.petArrayList.addAll(petArrayList)

        if (this.petArrayList.isEmpty()) {

            errorMessageVisible()
        } else {

            errorMessageGone()
        }

        componentListPetBinding.listRecycler.let { recycler ->

            recycler.layoutManager = GridLayoutManager(context, ComponentSetting.GRID_LAYOUT_TWO)

            recycler.adapter = listPetAdapter
        }

        listPetAdapter.submitList(this.petArrayList)
    }

    override fun adapter() {

        listPetAdapter = ListPetAdapter()

        listPetAdapter.submitList(petArrayList)
    }
}