package com.sunrisekcdevelopers.ui_components.components.st_setting_menu_item

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.sunrisekcdevelopers.styles.R
import com.sunrisekcdevelopers.ui_components.databinding.StSettingMenuItemBinding
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.visible
import kotlin.random.Random

open class StSettingMenuItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StSettingMenuItemBinding = StSettingMenuItemBinding.inflate(LayoutInflater.from(context), this)

    private var switchState: SwitchState = SwitchState.Off
    private var isChecked: Boolean = false

    init {
        // this is set here since the colors aren't applied when simply set on XML
        binding.root.background = ContextCompat.getDrawable(context, com.sunrisekcdevelopers.ui_components.R.drawable.background_placeholder_rectangle)
        binding.root.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.light_grey))
    }

    fun isChecked(): Boolean = isChecked

    fun setTitle(title: String) {
        if (title.isNotEmpty()) {
            binding.stSettingMenuItemTitle.text = title
            binding.stSettingMenuItemTitle.visible()
        }
    }

    fun setCaption(caption: String) {
        if (caption.isNotEmpty()) {
            binding.stSettingMenuItemSubtitle.text = caption
            binding.stSettingMenuItemSubtitle.visible()
        }
    }

    fun showLeftIcon(show: Boolean = true) {
        when (show) {
            true -> binding.stSettingMenuItemLeftIcon.visible()
            false -> binding.stSettingMenuItemLeftIcon.gone()
        }
    }

    fun showRightIcon(show: Boolean = true) {
        when (show) {
            true -> binding.stSettingMenuItemRightIcon.visible()
            false -> binding.stSettingMenuItemRightIcon.gone()
        }
    }

    fun showSwitchComponent(show: Boolean = true) {
        when (show) {
            true -> {
                binding.stSettingMenuItemSwitch.visible()
                addSwitchToggleListener()
            }
            false -> binding.stSettingMenuItemSwitch.gone()
        }
    }

    fun setSwitchState(state: SwitchState) {
        switchState = state
        toggleSwitchState()
    }

    fun setOnActionClickAction(action: View.() -> Unit) {
        binding.root.setOnClickListener { action(it) }
    }

    private fun addSwitchToggleListener() {
        binding.stSettingMenuItemSwitch.setOnCheckedChangeListener { _, isChecked ->
            switchState = when (isChecked) {
                true -> SwitchState.On
                false -> SwitchState.Off
            }
        }
    }

    private fun toggleSwitchState() {
        when (switchState) {
            SwitchState.Off -> binding.stSettingMenuItemSwitch.isChecked = false
            SwitchState.On -> binding.stSettingMenuItemSwitch.isChecked = true
        }
    }

    sealed interface SwitchState {
        object On : SwitchState
        object Off : SwitchState
    }
}