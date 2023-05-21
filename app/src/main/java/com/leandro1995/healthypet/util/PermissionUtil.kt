package com.leandro1995.healthypet.util

import android.Manifest
import androidx.fragment.app.FragmentActivity
import com.permissionx.guolindev.PermissionX

class PermissionUtil {

    companion object {

        fun cameraPermission(fragmentActivity: FragmentActivity, result: () -> Unit) {

            PermissionX.init(fragmentActivity).permissions(Manifest.permission.CAMERA)
                .request { isPermission, _, _ ->

                    if (isPermission) {

                        result()
                    }
                }
        }
    }
}