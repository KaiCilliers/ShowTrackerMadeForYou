package com.sunrisekcdevelopers.ui_components.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.google.android.material.chip.Chip
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StWrappedTagListBinding
import com.sunrisekcdevelopers.ui_components.withRecycle

@SuppressLint("Recycle")
class StWrappedTagList @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StWrappedTagListBinding = StWrappedTagListBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
        context.obtainStyledAttributes(attrs, R.styleable.StWrappedTagList).withRecycle {
            getString(R.styleable.StWrappedTagList_stwlTitle)?.also { binding.stWrappedTagListTitle.text = it }
        }
    }

    fun setTitle(title: String) {
        binding.stWrappedTagListTitle.text = title
    }

    // the tye of list should include some onclick for navigation
    fun setTags(list: List<String>) {
        list.forEach {
            val tag = Chip(context)
            tag.text = it
            binding.stWrappedTagListGroup.addView(tag)
        }
    }

}