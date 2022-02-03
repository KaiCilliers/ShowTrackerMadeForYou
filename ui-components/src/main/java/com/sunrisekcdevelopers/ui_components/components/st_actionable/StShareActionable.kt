package com.sunrisekcdevelopers.ui_components.components.st_actionable

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes

class StShareActionable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : StActionable(context, attrs, defStyleAttr, defStyleRes) {

    init {
        setIcon(ActionableIcon.SHARE)
        setLabel("Share")
        // TODO add logic to toggle between like and unlike state
        setOnClickListener {  }
    }

}