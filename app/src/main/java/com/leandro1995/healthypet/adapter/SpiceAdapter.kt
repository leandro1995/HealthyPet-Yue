package com.leandro1995.healthypet.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.model.entity.Spice

class SpiceAdapter constructor(
    private val activity: Activity,
    private val spiceArrayList: ArrayList<Spice>
) : BaseAdapter() {

    private var inflater: LayoutInflater = LayoutInflater.from(activity)

    override fun getCount(): Int {

        return spiceArrayList.size
    }

    override fun getItem(position: Int): Any {

        return position
    }

    override fun getItemId(position: Int): Long {

        return spiceArrayList[position].id.toLong()
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        return inflater.inflate(R.layout.item_spice, null).apply {

            findViewById<TextView>(R.id.spiceText).text =
                spiceArrayList[position].text(activity = activity)
        }
    }
}