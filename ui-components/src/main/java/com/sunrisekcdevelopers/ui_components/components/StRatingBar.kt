package com.sunrisekcdevelopers.ui_components.components

import android.content.Context
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.lifecycle.*
import com.sunrisekcdevelopers.logging.timber
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StRatingBarBinding
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.visible
import kotlinx.coroutines.*
import java.util.logging.Handler

class StRatingBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0 ,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val log by timber()
    private val binding: StRatingBarBinding = StRatingBarBinding.inflate(LayoutInflater.from(context), this)
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var maxRating = MAX_RATING

    companion object {
        const val MAX_RATING = 10
        const val STAR_PADDING_DEF = 2
    }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.StRatingBar).apply {
            if (getBoolean(R.styleable.StRatingBar_strb_show_value_indicator, true)) {
                binding.stRatingBarValue.visible()
            } else {
                binding.stRatingBarValue.gone()
            }
            maxRating = getInt(R.styleable.StRatingBar_strb_max_value, MAX_RATING)
            getInt(R.styleable.StRatingBar_strb_star_padding, STAR_PADDING_DEF).let { padding ->
                binding.ratingBar.starPadding = padding
            }
            recycle()
        }
    }

    fun setRating(rating: Float) {
        binding.stRatingBarValue.text = rating.toString()
        scope.launch {
            while(true) {
                for (i in 0..rating.toInt()) {
                    binding.ratingBar.rating = i.toFloat()
                    // todo extract to constant
                    delay(100)
                }
                binding.ratingBar.rating = rating
                delay(1000)
            }
        }
    }

    fun setMaxRating(value: Int) {
        maxRating = value
    }

}