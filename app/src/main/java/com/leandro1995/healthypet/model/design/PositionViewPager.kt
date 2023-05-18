package com.leandro1995.healthypet.model.design

class PositionViewPager constructor(var position: Int) {

    fun pagePosition(maxPosition: Int): Boolean {

        var pagePosition = position

        pagePosition += 1

        position = pagePosition

        return position == maxPosition
    }
}