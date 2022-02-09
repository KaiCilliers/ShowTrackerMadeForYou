package com.sunrisekcdevelopers.ui_components.components.st_setting_menu_item

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.withRecycle
import kotlin.random.Random

@SuppressLint("Recycle")
class StSettingGroupItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : StSettingMenuItem(context, attrs, defStyleAttr, defStyleRes) {

    init {
        setTitle("nice ${Random(Int.MAX_VALUE).nextInt()}")
        showLeftIcon()
        context.obtainStyledAttributes(attrs, R.styleable.StSettingGroupItem).withRecycle {
            getBoolean(R.styleable.StSettingGroupItem_ssgiChecked, false).also {
                if (it) {
                    // i am trying to avoid setting multiple children as checked using XML attribute - this solution is not working xD
                    if(this@StSettingGroupItem.parent is StSettingGroup) {
                        if (!(this@StSettingGroupItem.parent as StSettingGroup).hasCheckedItem) {
                            setChecked()
                            (this@StSettingGroupItem.parent as StSettingGroup).hasCheckedItem = true
                        }
                    } else {
                        setChecked()
                    }
                }
            }
        }
    }

    fun setChecked() {
        showRightIcon()
    }

    fun setUnChecked() {
        showRightIcon(false)
    }

}