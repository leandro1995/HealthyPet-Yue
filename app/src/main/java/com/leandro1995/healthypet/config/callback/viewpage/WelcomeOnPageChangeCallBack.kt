package com.leandro1995.healthypet.config.callback.viewpage

import androidx.viewpager2.widget.ViewPager2

class WelcomeOnPageChangeCallBack : ViewPager2.OnPageChangeCallback() {

    private var isStatus = false

    var viewPagePositionCallBack: ViewPagePositionCallBack? = null

    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)

        if (isStatus) {

            isViewPagePosition(position = position)
        } else {
            isStatus = true
        }
    }

    private fun isViewPagePosition(position: Int) {

        if (viewPagePositionCallBack != null) {

            viewPagePositionCallBack!!.position(position = position)
        }
    }
}