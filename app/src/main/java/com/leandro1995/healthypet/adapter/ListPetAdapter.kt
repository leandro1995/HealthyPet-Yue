package com.leandro1995.healthypet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.entity.Pet

class ListPetAdapter : ListAdapter<Pet, ListPetAdapter.ListPetViewHolder>(PetDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPetViewHolder {

        return ListPetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_pet, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListPetViewHolder, position: Int) {

    }

    class ListPetViewHolder constructor(view: View) : RecyclerView.ViewHolder(view)

    class PetDiffUtil : DiffUtil.ItemCallback<Pet>() {

        override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {

            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {

            return areItemsTheSame(oldItem, newItem)
        }
    }
}