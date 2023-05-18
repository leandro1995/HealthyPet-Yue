package com.leandro1995.healthypet.config.callback.intent

import com.leandro1995.healthypet.model.design.PositionViewPager

interface WelcomeIntentCallBack {

    fun view()

    fun positionPage(positionViewPager: PositionViewPager)
}