package com.sunrisekcdevelopers.ui_components.components.st_setting_menu_item

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.sunrisekcdevelopers.styles.R

// https://bitbucket.org/ManuelMato/customradiobutton/src/develop/app/src/main/java/com/example/manuel/commons/ui/radiobutton/CustomRadioGroup.java
class StSettingGroup @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    var hasCheckedItem: Boolean = false

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        if (child is StSettingGroupItem) {
            child.setOnClickListener { selectedView ->
                setAllItemsToUnselected()
                setItemToSelectedState(selectedView as StSettingGroupItem)
            }
        }
        super.addView(child, index, params)
    }

    private fun setAllItemsToUnselected() {
        for (i in 0..childCount) {
            val child = getChildAt(i)
            if (child is StSettingGroupItem) {
                setItemToUnselectedState(child)
            }
        }
    }

    private fun setItemToUnselectedState(item: StSettingGroupItem) {
        item.alpha = 0.5f
        item.setUnChecked()
    }

    private fun setItemToSelectedState(item: StSettingGroupItem) {
        item.alpha = 1.0f
        item.setChecked()
    }
}