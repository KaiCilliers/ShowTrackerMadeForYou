package com.sunrisekcdevelopers.ui_components.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.ui_components.databinding.StSeasonEpisodeItemBinding

class StSeasonEpisodeItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StSeasonEpisodeItemBinding = StSeasonEpisodeItemBinding.inflate(LayoutInflater.from(context), this)

    fun setNumber(number: Int) {
        binding.stSeasonEpisodeItemNumberToggle.setNumber(number)
    }

    fun setImage(url: String) {
        // this image loading class needs to be injected (constructor)
        StandardGlideImage().load(
            context = context,
            imgSrc = url,
            targetView = binding.stSeasonEpisodeItemImage
        )
    }

}