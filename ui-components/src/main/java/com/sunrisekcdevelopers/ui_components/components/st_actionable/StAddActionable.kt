package com.sunrisekcdevelopers.ui_components.components.st_actionable

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.sunrisekcdevelopers.ui_components.R

class StAddActionable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : StActionable(context, attrs, defStyleAttr, defStyleRes) {

    private var currentState: AddState = AddState.NotAdded

    init {
        setIcon(ActionableIcon.ADD)
        setLabel("My List")
        // TODO add logic to toggle between like and unlike state
        setOnClickListener {
            toggleState()
        }
    }

    private fun toggleState() {
        currentState = when (currentState) {
            AddState.Added -> AddState.NotAdded
            AddState.NotAdded -> AddState.Added
        }
        updateDrawable()
    }

    private fun updateDrawable() {
        when (currentState) {
            AddState.Added -> {
                setIcon(ActionableIcon.CHECK)
                setLabel("Added")
            }
            AddState.NotAdded -> {
                ActionableIcon.ADD
                setLabel("My List")
            }
        }
    }

    sealed class AddState {
        object Added : AddState()
        object NotAdded: AddState()
    }

}