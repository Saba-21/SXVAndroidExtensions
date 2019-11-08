package com.example.sxvandroidextensions.extensions.view.textView

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.sxvandroidextensions.extensions.view.TypefaceAndRelativeSizeSpan

fun TextView.setTypefaceSpannableText(
    fullText: String,
    linkText: String,
    typefaceId: Int,
    relativeSize: Float
) {
    val startIndex = fullText.indexOf(linkText)
    val endIndex = startIndex + linkText.length
    val result = SpannableString(fullText)
    val typeface = ResourcesCompat.getFont(this.context, typefaceId)
    if (typeface != null)
        result.setSpan(
            TypefaceAndRelativeSizeSpan(relativeSize, typeface),
            startIndex,
            endIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    this.text = result
}

fun TextView.setTextColorSpannableText(fullText: String, linkText: String, color: Int) {
    val startIndex = fullText.indexOf(linkText)
    val endIndex = startIndex + linkText.length
    val result = SpannableString(fullText)
    result.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(this.context, color)),
        startIndex,
        endIndex,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    this.text = result
}