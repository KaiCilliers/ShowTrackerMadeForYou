package com.sunrisekcdevelopers.ui_components.components.st_actionable

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes

class StEyeActionable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : StActionable(context, attrs, defStyleAttr, defStyleRes) {

    private var currentState: EyeState = EyeState.EyeOutline

    init {
        setIcon(ActionableIcon.EYE)
        setLabel("Watch")
        // TODO add logic to toggle between like and unlike state
        setOnClickListener { toggleState() }
    }

    private fun toggleState() {
        currentState = when (currentState) {
            EyeState.EyeFilled -> EyeState.EyeOutline
            EyeState.EyeOutline -> EyeState.EyeFilled
        }
        updateDrawable()
    }

    private fun updateDrawable() {
        when (currentState) {
            EyeState.EyeFilled -> {
                setIcon(ActionableIcon.CHECK)
                setLabel("Seen")
            }
            EyeState.EyeOutline -> {
                ActionableIcon.EYE
                setLabel("Watch")
            }
        }
    }

    sealed class EyeState {
        object EyeFilled: EyeState()
        object EyeOutline: EyeState()
    }

}