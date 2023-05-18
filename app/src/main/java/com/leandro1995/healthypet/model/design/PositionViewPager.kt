package com.leandro1995.healthypet.model.design

class PositionViewPager constructor(private var position: Int) {

    fun pagePosition(maxPosition: Int): Int {

        var pagePosition = position

        if (pagePosition == maxPosition) {

            pagePosition = 0
        } else {

            pagePosition += 1
        }

        return pagePosition
    }
}