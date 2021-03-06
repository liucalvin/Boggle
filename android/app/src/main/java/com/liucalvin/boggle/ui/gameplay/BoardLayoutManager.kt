package com.liucalvin.boggle.ui.gameplay

import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager

class BoardLayoutManager(activity: FragmentActivity, spanCount: Int) :
    GridLayoutManager(activity, spanCount) {

    override fun canScrollVertically(): Boolean {
        return false
    }

    override fun canScrollHorizontally(): Boolean {
        return false
    }

}