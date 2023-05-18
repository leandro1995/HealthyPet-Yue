package com.leandro1995.healthypet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.design.WelcomePage

class WelcomePageAdapter constructor(private val welcomePageArrayList: ArrayList<WelcomePage>) :
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

    }

    class WelcomePageHolder constructor(view: View) : RecyclerView.ViewHolder(view)
}