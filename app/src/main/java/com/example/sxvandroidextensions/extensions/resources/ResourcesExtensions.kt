package com.example.sxvandroidextensions.extensions.resources

import android.graphics.Typeface
import androidx.annotation.ColorRes
import androidx.annotation.FontRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

fun Fragment.color(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this.context!!, colorRes)
}

fun Fragment.typeFace(@FontRes fontRes: Int): Typeface {
    return ResourcesCompat.getFont(this.context!!, fontRes)!!
}