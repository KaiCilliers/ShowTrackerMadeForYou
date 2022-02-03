package com.sunrisekcdevelopers.ui_components.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StProgressBarBinding
import kotlinx.coroutines.delay

@SuppressLint("SetTextI18n")
class StProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout (context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StProgressBarBinding = StProgressBarBinding.inflate(LayoutInflater.from(context), this)

    private var count: Double = 0.0
    private var currentCheckMarkState: CheckMarkState = CheckMarkState.Off


    init {
        binding.stProgressBarTextIndicator.text = "34/100"
        binding.stProgressBarIndicator.showProgressText(true)
        setOnCheckClickListener {
            println("ok")
        }
    }

    // Just for display purposes
    suspend fun loop() {
        if (count >= 100) {
            count = 0.0
        }
        binding.stProgressBarIndicator.setProgressPercentage(count)
        count += 10
        delay(1000)
    }

    fun setOnCheckClickListener(action: View.() -> Unit) {
        binding.stProgressBarCheck.setOnClickListener {
            currentCheckMarkState = when (currentCheckMarkState) {
                CheckMarkState.Off -> CheckMarkState.On
                CheckMarkState.On -> CheckMarkState.Off
            }
            toggleCheckMark()
            action(this)
        }
    }

    private fun toggleCheckMark() {
        when(currentCheckMarkState) {
            CheckMarkState.Off -> {
                binding.stProgressBarIndicator.setProgressPercentage(0.0)
                binding.stProgressBarCheck.setImageDrawable(ContextCompat.getDrawable(context,com.willy.ratingbar.R.drawable.empty))
            }
            CheckMarkState.On -> {
                binding.stProgressBarIndicator.setProgressPercentage(100.0)
                binding.stProgressBarCheck.setImageDrawable(ContextCompat.getDrawable(context, com.willy.ratingbar.R.drawable.filled))
            }
        }
    }

    sealed class CheckMarkState {
        object On : CheckMarkState()
        object Off : CheckMarkState()
    }

}