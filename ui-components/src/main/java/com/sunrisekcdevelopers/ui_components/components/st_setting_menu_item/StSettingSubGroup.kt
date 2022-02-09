package com.sunrisekcdevelopers.ui_components.components.st_setting_menu_item

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StSettingMenuItemBinding
import com.sunrisekcdevelopers.ui_components.withRecycle

// Constraints not working properly - title and caption should be aligned with left icon
@SuppressLint("Recycle")
class StSettingSubGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : StSettingMenuItem(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StSettingMenuItemBinding = StSettingMenuItemBinding.inflate(LayoutInflater.from(context), this)

    init {
        showLeftIcon()
        // right icon needs to be set to arrow - not checkmark
        showRightIcon()
        showSwitchComponent(false)
        context.obtainStyledAttributes(attrs, R.styleable.StSettingSubGroup).withRecycle {
            getString(R.styleable.StSettingSubGroup_stssgSubGroupTitle).orEmpty().also { setSubGroupTitle(it) }
            getString(R.styleable.StSettingSubGroup_stssgCurrentSelection).orEmpty().also { setCurrentSelectionText(it) }
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun setSubGroupTitle(title: String) {
        setTitle(title)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun setCurrentSelectionText(text: String) {
        setCaption(text)
    }

    // for some reason onclick not working :(
    fun setOnClickNavAction(action: View.() -> Unit) {
        setOnActionClickAction { action(this) }
    }

}