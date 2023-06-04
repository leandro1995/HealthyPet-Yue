package com.leandro1995.healthypet.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.InjectionChecked

class InjectionCheckedAdapter :
    ListAdapter<InjectionChecked, InjectionCheckedAdapter.InjectionCheckedHolder>(
        InjectionCheckedDiffUtil()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InjectionCheckedHolder {

        return InjectionCheckedHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_injection_checked, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InjectionCheckedHolder, position: Int) {

        holder.injectionCheck.apply {

            isChecked = getItem(position).isChecked
            text = getItem(position).injection.name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class InjectionCheckedHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val injectionCheck: CheckBox = view.findViewById(R.id.injectionCheck)

        init {

            injectionCheck.setOnClickListener {

                currentList.forEach { it.isChecked = false }

                currentList[adapterPosition].isChecked = true

                notifyDataSetChanged()
            }
        }
    }

    class InjectionCheckedDiffUtil : DiffUtil.ItemCallback<InjectionChecked>() {

        override fun areItemsTheSame(
            oldItem: InjectionChecked, newItem: InjectionChecked
        ): Boolean {

            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: InjectionChecked, newItem: InjectionChecked
        ): Boolean {

            return areItemsTheSame(oldItem, newItem)
        }
    }
}