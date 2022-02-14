package com.sunrisekcdevelopers.ui_components.components.st_actionable

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes

// idea
// share your playlist to another user via whatever medium like messenger
// if user has this app they can open the shared link
// be directed to showtracker - a dedicated screen to showcase the other user's playlist
// you can then select which ones to add to your own
// or add the entire playlist into one of your playlist slots
// limited to 4 or something for free accounts - paid gets more or unlimited
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