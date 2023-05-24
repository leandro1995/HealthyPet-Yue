package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.util.DesignUtil

class ToCompleteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_complete)

        statusBar()
    }

    private fun statusBar() {

        DesignUtil.statusBarTransparent(window = window)
    }
}