package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.ActivityToCompleteBinding
import com.leandro1995.healthypet.util.DesignUtil

class ToCompleteActivity : AppCompatActivity() {

    private lateinit var toCompleteBinding: ActivityToCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toCompleteBinding = DataBindingUtil.setContentView(this, R.layout.activity_to_complete)

        statusBar()
    }

    private fun statusBar() {

        DesignUtil.statusBarTransparent(window = window)
    }
}