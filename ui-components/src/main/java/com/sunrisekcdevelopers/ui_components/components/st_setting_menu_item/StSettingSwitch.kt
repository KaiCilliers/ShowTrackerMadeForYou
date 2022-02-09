package com.sunrisekcdevelopers.ui_components.components.st_setting_menu_item

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.withRecycle

@SuppressLint("Recycle")
class StSettingSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : StSettingMenuItem(context, attrs, defStyleAttr, defStyleRes) {

    init {
        showLeftIcon()
        showRightIcon(false)
        showSwitchComponent()
    }

    fun setSettingName(name: String) {
        setTitle(name)
    }

}