package com.leandro1995.healthypet.intent

import com.leandro1995.healthypet.model.design.PositionViewPager

sealed class WelcomeIntent {

    object View : WelcomeIntent()

    data class PositionPage constructor(val positionViewPager: PositionViewPager) : WelcomeIntent()
}