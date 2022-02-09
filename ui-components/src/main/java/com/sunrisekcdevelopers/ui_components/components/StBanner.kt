package com.sunrisekcdevelopers.ui_components.components

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StBannerBinding
import com.sunrisekcdevelopers.ui_components.dp
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.visible

class StBanner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StBannerBinding = StBannerBinding.inflate(LayoutInflater.from(context), this)

    init {
        clipToOutline = true
        binding.root.background = ContextCompat.getDrawable(context, R.drawable.background_placeholder_rounded_corners)
        // todo fetch ?attr value with symantic meaning - not color directly (take from theme - so that when theme changes so does this color)
        binding.root.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, com.sunrisekcdevelopers.styles.R.color.light_grey))
        binding.root.setPadding(4.dp, 4.dp, 4.dp, 4.dp)
    }

    fun setMessage(msg: String) {
        binding.stBannerText.text = msg
    }

    fun setIcon(icon: BannerIcon) {
        when (icon) {
            BannerIcon.Heart -> {
                binding.stBannerIcon.setImageDrawable(
                    ContextCompat.getDrawable(binding.stBannerIcon.context, R.drawable.heart_filled_24)
                )
            }
            BannerIcon.Share -> {
                binding.stBannerIcon.setImageDrawable(
                    ContextCompat.getDrawable(binding.stBannerIcon.context, R.drawable.share_24)
                )
            }
        }
    }

    fun showIcon(show: Boolean = true) {
        if (show) binding.stBannerIcon.visible() else binding.stBannerIcon.gone()
    }

    sealed class BannerIcon {
        object Heart : BannerIcon()
        object Share : BannerIcon()
    }

}