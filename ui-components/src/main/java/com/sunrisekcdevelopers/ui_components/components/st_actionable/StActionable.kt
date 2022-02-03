package com.sunrisekcdevelopers.ui_components.components.st_actionable

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.appcompat.content.res.AppCompatResources
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StActionableBinding
import com.sunrisekcdevelopers.ui_components.withRecycle

@SuppressLint("Recycle")
open class StActionable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StActionableBinding =
        StActionableBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
        context.obtainStyledAttributes(attrs, R.styleable.StActionable).withRecycle {
            getInt(R.styleable.StActionable_stac_icon, 0).also { setIcon(it.asEnum()) }
            getString(R.styleable.StActionable_stac_text).orEmpty().also { setLabel(it) }
        }
    }

    private fun Int.asEnum(): ActionableIcon {
        return when (this) {
            1 -> ActionableIcon.HEART_OUTLINE
            2 -> ActionableIcon.SHARE
            3 -> ActionableIcon.EYE
            4 -> ActionableIcon.CHECK
            5 -> ActionableIcon.HEART_FILLED
            else -> ActionableIcon.ADD
        }
    }

    fun setIcon(type: ActionableIcon) {
        val icon = when (type) {
            ActionableIcon.ADD -> R.drawable.add_24
            ActionableIcon.HEART_OUTLINE -> R.drawable.heart_border_24
            ActionableIcon.SHARE -> R.drawable.share_24
            ActionableIcon.EYE -> R.drawable.eye_24
            ActionableIcon.CHECK -> R.drawable.check_24
            ActionableIcon.HEART_FILLED -> R.drawable.heart_filled_24
        }
        binding.stActionableIcon.setImageDrawable(AppCompatResources.getDrawable(context, icon))
    }

    fun setLabel(value: String) {
        binding.stActionableLabel.text = value
    }

    // You'll probably need to expose some data like an ID instead of a View
    fun setOnClickListener(action: (View) -> Unit) {
        binding.root.setOnClickListener { action(it) }
    }

}
