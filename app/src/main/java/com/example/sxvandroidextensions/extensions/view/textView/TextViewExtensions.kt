package com.example.sxvandroidextensions.extensions.view.textView

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.View
import com.example.sxvandroidextensions.extensions.view.TypefaceAndRelativeSizeSpan

fun SpannableString.addClickListener(
    linkText: String,
    listener: () -> Unit
): SpannableString {
    val span = object : ClickableSpan() {
        override fun onClick(widget: View) {
            listener.invoke()
        }
    }
    addSpan(linkText, span)
    return this
}

fun SpannableString.addRelativeSize(
    linkText: String,
    relativeSize: Float
): SpannableString {
    val span = RelativeSizeSpan(relativeSize)
    addSpan(linkText, span)
    return this
}

fun SpannableString.addTypeface(
    linkText: String,
    typeface: Typeface
): SpannableString {
    val span = TypefaceAndRelativeSizeSpan(1f, typeface)
    addSpan(linkText, span)
    return this
}

fun SpannableString.addBackground(
    linkText: String,
    color: Int
): SpannableString {
    val span = BackgroundColorSpan(color)
    addSpan(linkText, span)
    return this
}

fun SpannableString.addTextColor(
    linkText: String,
    color: Int
): SpannableString {
    val span = ForegroundColorSpan(color)
    addSpan(linkText, span)
    return this
}

fun SpannableString.addSpan(linkText: String, span: Any): SpannableString {
    val fullText = this.toString()
    val startIndex = fullText.indexOf(linkText)
    val endIndex = startIndex + linkText.length
    this.setSpan(span, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    return this
}