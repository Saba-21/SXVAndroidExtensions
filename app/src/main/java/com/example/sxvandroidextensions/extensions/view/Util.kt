package com.example.sxvandroidextensions.extensions.view

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.RelativeSizeSpan

class TypefaceAndRelativeSizeSpan(relativeSize: Float, private val typeFace: Typeface) :
    RelativeSizeSpan(relativeSize) {

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        applyCustomTypeFace(ds, typeFace)
    }

    private fun applyCustomTypeFace(paint: Paint, tf: Typeface) {
        val oldStyle: Int
        val old = paint.typeface
        oldStyle = old?.style ?: 0
        val fake = oldStyle and tf.style.inv()
        if (fake and Typeface.BOLD != 0) {
            paint.isFakeBoldText = true
        }
        if (fake and Typeface.ITALIC != 0) {
            paint.textSkewX = -0.25f
        }
        paint.typeface = tf
    }

}