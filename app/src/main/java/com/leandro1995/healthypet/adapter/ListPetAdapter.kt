package com.leandro1995.healthypet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.component.util.DesignComponentUtil
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.model.entity.Pet

class ListPetAdapter : ListAdapter<Pet, ListPetAdapter.ListPetViewHolder>(PetDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPetViewHolder {

        return ListPetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_pet, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListPetViewHolder, position: Int) {

        holder.apply {

            getItem(position).let { pet ->

                @Suppress("DEPRECATION")
                photoSimple.setImageURI(pet.photoFile())
                sexImage.setImageResource(DesignComponentUtil.sexImage(isSex = pet.isSex))
                nameText.text = pet.name
                dateText.text = pet.date(format = Setting.DATE_FORMAT_ONE)
            }
        }
    }

    class ListPetViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val photoSimple: SimpleDraweeView = view.findViewById(R.id.photoSimple)
        val sexImage: ImageView = view.findViewById(R.id.sexImage)
        val nameText: TextView = view.findViewById(R.id.nameText)
        val dateText: TextView = view.findViewById(R.id.dateText)
    }

    class PetDiffUtil : DiffUtil.ItemCallback<Pet>() {

        override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {

            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {

            return areItemsTheSame(oldItem, newItem)
        }
    }
}