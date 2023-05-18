package com.leandro1995.healthypet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.WelcomePage

class WelcomePageAdapter(private val welcomePageArrayList: ArrayList<WelcomePage>) :
    RecyclerView.Adapter<WelcomePageAdapter.WelcomePageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomePageHolder {

        return WelcomePageHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_welcome, parent, false)
        )
    }

    override fun getItemCount(): Int {

        return welcomePageArrayList.size
    }

    override fun onBindViewHolder(holder: WelcomePageHolder, position: Int) {

        holder.apply {

            welcomeImage.setImageResource(welcomePageArrayList[position].idImage)
        }
    }

    class WelcomePageHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val welcomeImage: ImageView = view.findViewById(R.id.welcomeImage)
    }
}