package com.example.admin.pager2.exts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by tuanluong on 10/18/17.
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun View.toggleVisibility() {
    visibility = if (visibility == View.GONE) {
        View.VISIBLE
    } else {
        View.GONE
    }
}