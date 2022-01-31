package com.sunrisekcdevelopers.ui_components

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatTextView

open class StTextViewBody @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyleAttr) {
    init {
        this.setTextAppearance(com.sunrisekcdevelopers.styles.R.style.TextAppearance_ShowTracker_Body1)
    }
}