package com.sunrisekcdevelopers.ui_components.components.st_actionable

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes

class StHeartActionable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : StActionable(context, attrs, defStyleAttr, defStyleRes) {

    private var currentState: HeartState = HeartState.Outline

    init {
        setIcon(ActionableIcon.HEART_OUTLINE)
        setLabel("Like")
        // TODO add logic to toggle between like and unlike state
        setOnClickListener { toggleState()  }
    }

    private fun toggleState() {
        currentState = when (currentState) {
            HeartState.Filled -> HeartState.Outline
            HeartState.Outline -> HeartState.Filled
        }
        updateDrawable()
    }

    private fun updateDrawable() {
        when(currentState) {
            HeartState.Filled -> {
                setIcon(ActionableIcon.HEART_FILLED)
                setLabel("Liked")
            }
            HeartState.Outline -> {
                setIcon(ActionableIcon.HEART_OUTLINE)
                setLabel("Like")
            }
        }
    }

    sealed class HeartState {
        object Filled: HeartState()
        object Outline: HeartState()
    }

}