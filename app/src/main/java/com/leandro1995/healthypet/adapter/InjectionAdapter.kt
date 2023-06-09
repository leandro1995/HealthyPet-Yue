package com.leandro1995.healthypet.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.adapter.InjectionAdapterCallBack
import com.leandro1995.healthypet.model.entity.Injection
import com.leandro1995.healthypet.util.ArrayListUtil

class InjectionAdapter constructor(private val activity: Activity) :
    ListAdapter<Injection, InjectionAdapter.InjectionViewHolder>(InjectionDiffUtil()) {

    var injectionAdapterCallBack: InjectionAdapterCallBack? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InjectionViewHolder {

        return InjectionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_injection, parent, false)
        )
    }

    @Suppress("DEPRECATION")
    override fun onBindViewHolder(holder: InjectionViewHolder, position: Int) {

        holder.apply {

            getItem(position).let { injection ->

                photoSimple.setImageURI(injection.photoFile())
                dateText.text = injection.dateNextAppointment(format = Setting.DATE_FORMAT_ONE)
                injectionText.text = ArrayListUtil.typeInjection(
                    activity = activity, id = injection.typeInjection.id
                )!!.name
            }
        }
    }

    inner class InjectionViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val photoSimple: SimpleDraweeView = view.findViewById(R.id.photoSimple)
        val injectionText: TextView = view.findViewById(R.id.injectionText)
        val dateText: TextView = view.findViewById(R.id.dateText)
        private val seeMoreText: TextView = view.findViewById(R.id.seeMoreText)

        init {

            seeMoreText.setOnClickListener {

                isInjectionAdapter(injection = getItem(adapterPosition))
            }
        }
    }

    class InjectionDiffUtil : DiffUtil.ItemCallback<Injection>() {

        override fun areItemsTheSame(oldItem: Injection, newItem: Injection): Boolean {

            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Injection, newItem: Injection): Boolean {

            return areItemsTheSame(oldItem, newItem)
        }
    }

    private fun isInjectionAdapter(injection: Injection) {

        if (injectionAdapterCallBack != null) {

            injectionAdapterCallBack!!.injection(injection = injection)
        }
    }
}