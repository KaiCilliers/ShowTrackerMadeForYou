package com.sunrisekcdevelopers.ui_components.components

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.doOnTextChanged
import com.sunrisekcdevelopers.ui_components.databinding.StSearchBarBinding
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.invisible
import com.sunrisekcdevelopers.ui_components.visible

class StSearchBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StSearchBarBinding by lazy(LazyThreadSafetyMode.NONE) {
        StSearchBarBinding.inflate(LayoutInflater.from(context), this)
    }

    private var onTextChangedAction: (text: CharSequence?, start: Int, before: Int, count: Int) -> Unit = {_,_,_,_ ->}

    init {
        binding.stSearchBarText.doOnTextChanged { text, start, before, count ->
            onTextChangedAction(text,start, before, count)
            toggleCloseIcon()
        }
        binding.stSearchBarIconClose.setOnClickListener {
            binding.stSearchBarText.text.clear()
            toggleCloseIcon()
        }
    }

    private fun toggleCloseIcon() {
        if (binding.stSearchBarText.text.isNotEmpty()) {
            binding.stSearchBarIconClose.visible()
        } else {
            binding.stSearchBarIconClose.invisible()
        }
    }

    fun setOnQueryTextChangeListener(action: (text: CharSequence?, start: Int, before: Int, count: Int) -> Unit) {
        onTextChangedAction = action
    }

    fun getQuery(): String {
        return binding.stSearchBarText.text as String
    }

    fun getQueryHint(): String {
        return binding.stSearchBarText.hint as String
    }

}