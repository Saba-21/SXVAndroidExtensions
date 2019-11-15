package com.example.sxvandroidextensions.extensions.view

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes
import androidx.core.view.*
import com.example.sxvandroidextensions.extensions.resources.getDimen
import com.example.sxvandroidextensions.misc.NoGetterException

fun View.show() {
    visibility = View.VISIBLE
}

fun View.goAway() {
    visibility = View.GONE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.visibleIf(visible: Boolean) {
    if (visible)
        show()
    else
        goAway()
}

fun View.justVisibleIf(visible: Boolean) {
    isVisible
    if (visible)
        show()
    else
        hide()
}

fun View.generateViewId() {
    id = ViewCompat.generateViewId()
}

inline var View.startPadding: Int
    get() = paddingLeft
    set(value) = setPadding(value, paddingTop, paddingRight, paddingBottom)

var View.topPadding: Int
    get() = paddingTop
    set(value) = setPadding(paddingLeft, value, paddingRight, paddingBottom)

inline var View.endPadding: Int
    get() = paddingLeft
    set(value) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

inline var View.bottomPadding: Int
    get() = paddingTop
    set(value) = setPadding(paddingLeft, paddingTop, paddingRight, value)

inline var View.startPaddingRes: Int
    get() = paddingLeft
    set(@DimenRes value) = setPadding(getDimen(value), paddingTop, paddingRight, paddingBottom)

var View.topPaddingRes: Int
    get() = paddingTop
    set(@DimenRes value) = setPadding(paddingLeft, getDimen(value), paddingRight, paddingBottom)

inline var View.endPaddingRes: Int
    get() = paddingLeft
    set(@DimenRes value) = setPadding(paddingLeft, paddingTop, getDimen(value), paddingBottom)

inline var View.bottomPaddingRes: Int
    get() = paddingTop
    set(@DimenRes value) = setPadding(paddingLeft, paddingTop, paddingRight, getDimen(value))

/**
 * Sets this view's horizontal padding
 * @throws NoGetterException if you try to get its value
 * */

var View.horizontalPadding: Int
    get() = throw NoGetterException()
    inline set(value) = setPadding(value, paddingTop, value, paddingBottom)

/**
 * Sets this view's vertical padding
 * @throws NoGetterException if you try to get its value
 * */

var View.verticalPadding: Int
    get() = throw NoGetterException()
    inline set(value) = setPadding(paddingLeft, value, paddingRight, value)


/**
 * Sets this view's horizontal padding with resource value
 * @throws NoGetterException if you try to get its value
 * */

var View.horizontalPaddingRes: Int
    get() = throw NoGetterException()
    inline set(@DimenRes value) = setPadding(getDimen(value), paddingTop, getDimen(value), paddingBottom)

/**
 * Sets this view's vertical padding with resource value
 * @throws NoGetterException if you try to get its value
 * */

var View.verticalPaddingRes: Int
    get() = throw NoGetterException()
    inline set(@DimenRes value) = setPadding(paddingLeft, getDimen(value), paddingRight, getDimen(value))

/**
 * Sets this view's start margin with resource value
 * @see ViewGroup.MarginLayoutParams.setMarginStart
 * @throws NoGetterException if you try to get its value
 * */


var View.startMarginRes: Int
    get() = throw NoGetterException()
    set(@DimenRes value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            marginStart = getDimen(value)
        }
    }

/**
 * Sets this view's top margin with resource value
 * @see ViewGroup.MarginLayoutParams.topMargin
 * @throws NoGetterException if you try to get its value
 * */

var View.topMarginRes: Int
    get() = throw NoGetterException()
    set(@DimenRes value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = getDimen(value)
        }
    }

/**
 * Sets this view's end margin with resource value
 * @see ViewGroup.MarginLayoutParams.setMarginEnd
 * @throws NoGetterException if you try to get its value
 * */

var View.endMarginRes: Int
    get() = throw NoGetterException()
    set(@DimenRes value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            marginEnd = getDimen(value)
        }
    }

/**
 * Sets this view's bottom margin with resource value
 * @see ViewGroup.MarginLayoutParams.bottomMargin
 * @throws NoGetterException if you try to get its value
 * */

var View.bottomMarginRes: Int
    get() = throw NoGetterException()
    set(@DimenRes value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = getDimen(value)
        }
    }

/**
 * Sets this view's horizontal margin with resource value
 * @see ViewGroup.MarginLayoutParams.setMarginStart
 * @see ViewGroup.MarginLayoutParams.setMarginEnd
 * @throws NoGetterException if you try to get its value
 * */

var View.horizontalMarginRes: Int
    get() = throw NoGetterException()
    set(@DimenRes value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            marginStart = getDimen(value)
            marginEnd = getDimen(value)
        }
    }

/**
 * Sets this view's vertical margin with resource value
 * @see ViewGroup.MarginLayoutParams.topMargin
 * @see ViewGroup.MarginLayoutParams.bottomMargin
 * @throws NoGetterException if you try to get its value
 * */

var View.verticalMarginRes: Int
    get() = throw NoGetterException()
    set(@DimenRes value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = getDimen(value)
            bottomMargin = getDimen(value)
        }
    }