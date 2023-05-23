package com.leandro1995.healthypet.config.listener

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import com.leandro1995.healthypet.config.callback.spinner.SpiceSpinnerCallBack

class SpiceSpinnerListener : OnItemSelectedListener {

    var spiceSpinnerCallBack: SpiceSpinnerCallBack? = null

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        isSpiceSpinner(position = position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun isSpiceSpinner(position: Int) {

        if (spiceSpinnerCallBack != null) {

            spiceSpinnerCallBack!!.position(position = position)
        }
    }
}