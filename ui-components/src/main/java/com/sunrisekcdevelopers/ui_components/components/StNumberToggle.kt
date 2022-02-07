package com.sunrisekcdevelopers.ui_components.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.sunrisekcdevelopers.ui_components.databinding.StNumberToggleBinding
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.visible

class StNumberToggle @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding : StNumberToggleBinding = StNumberToggleBinding.inflate(LayoutInflater.from(context), this)

    private var state: NumberToggleState = NumberToggleState.Number

    init {
        // you can always add a lambda to this onclick for custom code execution
        binding.root.setOnClickListener {
            when(state) {
                NumberToggleState.Check -> {
                    binding.stNumberToggleCheckmark.gone()
                    state = NumberToggleState.Number
                    binding.stNumberToggleNumber.visible()
                }
                NumberToggleState.Number -> {
                    binding.stNumberToggleNumber.gone()
                    state = NumberToggleState.Check
                    binding.stNumberToggleCheckmark.visible()
                }
            }
        }
    }

    fun setNumber(number: Int) {
        binding.stNumberToggleNumber.text = number.toString()
    }

    sealed interface NumberToggleState {
        object Check : NumberToggleState
        object Number : NumberToggleState
    }

}