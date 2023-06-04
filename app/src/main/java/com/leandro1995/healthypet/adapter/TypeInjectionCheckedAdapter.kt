package com.leandro1995.healthypet.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.TypeInjectionChecked

class TypeInjectionCheckedAdapter :
    ListAdapter<TypeInjectionChecked, TypeInjectionCheckedAdapter.InjectionCheckedHolder>(
        TypeInjectionCheckedDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InjectionCheckedHolder {

        return InjectionCheckedHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_type_injection_checked, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InjectionCheckedHolder, position: Int) {

        holder.injectionRadio.apply {

            isChecked = getItem(position).isChecked
            text = getItem(position).typeInjection.name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class InjectionCheckedHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val injectionRadio: RadioButton = view.findViewById(R.id.injectionRadio)

        init {

            injectionRadio.setOnClickListener {

                currentList.forEach { it.isChecked = false }

                currentList[adapterPosition].isChecked = true

                notifyDataSetChanged()
            }
        }
    }

    class TypeInjectionCheckedDiffUtil : DiffUtil.ItemCallback<TypeInjectionChecked>() {

        override fun areItemsTheSame(
            oldItem: TypeInjectionChecked, newItem: TypeInjectionChecked
        ): Boolean {

            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TypeInjectionChecked, newItem: TypeInjectionChecked
        ): Boolean {

            return areItemsTheSame(oldItem, newItem)
        }
    }
}