package com.sunrisekcdevelopers.styles

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.ContextMenu
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatTextView

// might be useful - what is run used for? recyling?
fun Context.getThemeColor(
    @AttrRes themeAttrId: Int
) : Int {
    return obtainStyledAttributes(
        intArrayOf(themeAttrId)
    ).use {
        it.getColor(0, Color.MAGENTA)
    }
}

// for now just a reminder to not just set defualt style values to 0
@Suppress("Unused", "UNUSED_PARAMETER")
class ExampleTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = android.R.attr.textViewStyle,
    @StyleRes defStyleRes: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr)