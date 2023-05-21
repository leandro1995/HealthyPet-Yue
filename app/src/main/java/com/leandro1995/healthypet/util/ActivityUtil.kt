package com.leandro1995.healthypet.util

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ActivityUtil {

    companion object {

        fun activityResultLauncher(activity: Activity, resultData: (data: Intent) -> Unit) =
            (activity as AppCompatActivity).registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->

                if (result.resultCode == Activity.RESULT_OK) {

                    resultData(result.data!!)
                }
            }
    }
}