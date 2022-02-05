package com.sunrisekcdevelopers.ui_components.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.sunrisekcdevelopers.ui_components.databinding.StSeasonProgressBinding
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.visible

class StSeasonProgress @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StSeasonProgressBinding = StSeasonProgressBinding.inflate(LayoutInflater.from(context), this)

    private var maxValue: Double = DEF_MAX_VALUE
    private var currentProgress: Double = ZERO_VALUE
    private var state: SeasonProgressState = SeasonProgressState.Incomplete

    companion object {
        const val ZERO_VALUE = 0.0
        const val DEF_MAX_VALUE = 100.0
    }

    init {
        binding.stSeasonProgressIndicator.setOnCheckClickListener { currentCheckMarkState ->
            currentProgress = when (currentCheckMarkState) {
                StProgressBar.CheckMarkState.Off -> { ZERO_VALUE }
                StProgressBar.CheckMarkState.On -> { maxValue }
            }
            setProgress()
        }
    }

    fun setProgress(progress: Double) {
        currentProgress = progress
        setProgress()
    }

    fun showBanner(show: Boolean = true) {
        if (show)
            binding.stSeasonProgressBanner.visible()
        else
            binding.stSeasonProgressBanner.gone()
    }

    // there can be some presets for this banner later
    fun setBannerMessage(msg: String) {
        binding.stSeasonProgressBanner.setMessage(msg)
        binding.stSeasonProgressBanner.setIcon(StBanner.BannerIcon.Heart)
    }

    fun setTitle(title: String) {
        binding.stSeasonProgressTitle.text = title
    }

    fun setMaxValue(max: Double) {
        maxValue = max
        setProgress()
    }

    private fun setProgress() {
        if (currentProgress == maxValue) {
            state = SeasonProgressState.Complete
        } else if (state == SeasonProgressState.Complete) {
            state = SeasonProgressState.Incomplete
        }
        binding.stSeasonProgressIndicator.setData(currentProgress, maxValue)
    }

    sealed class SeasonProgressState {
        object Complete : SeasonProgressState()
        object Incomplete : SeasonProgressState()
    }

}