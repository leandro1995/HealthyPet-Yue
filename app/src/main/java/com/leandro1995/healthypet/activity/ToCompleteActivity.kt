package com.leandro1995.healthypet.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.background.ToCompleteBackground
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.databinding.ActivityToCompleteBinding
import com.leandro1995.healthypet.extension.coroutineScope
import com.leandro1995.healthypet.extension.putInt
import com.leandro1995.healthypet.util.DesignUtil
import kotlinx.coroutines.Dispatchers

class ToCompleteActivity : AppCompatActivity() {

    private lateinit var toCompleteBinding: ActivityToCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toCompleteBinding = DataBindingUtil.setContentView(this, R.layout.activity_to_complete)

        putExtra()
        statusBar()
        timeOut()
        onBack()
    }

    private fun putExtra() {

        toCompleteBinding.messageText.text =
            getString(DesignUtil.messageId(code = Setting.CODE_MESSAGE_PUT putInt this))
    }

    private fun statusBar() {

        DesignUtil.statusBarTransparent(window = window)
    }

    private fun timeOut() {

        coroutineScope(context = Dispatchers.Main, method = {

            ToCompleteBackground.timeOut(method = {

                setResult(Activity.RESULT_OK, Intent())
                finish()
            })
        })
    }

    private fun onBack() {

        DesignUtil.onBackPressed(activity = this)
    }
}