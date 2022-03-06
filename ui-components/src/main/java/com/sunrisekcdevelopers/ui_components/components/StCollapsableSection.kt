package com.sunrisekcdevelopers.ui_components.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.sunrisekcdevelopers.ui_components.*
import com.sunrisekcdevelopers.ui_components.databinding.StCollapsableSectionBinding

// this needs a small animation when hiding and showing list
@SuppressLint("Recycle")
class StCollapsableSection @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StCollapsableSectionBinding by lazy(LazyThreadSafetyMode.NONE) {
        StCollapsableSectionBinding.inflate(LayoutInflater.from(context), this)
    }

    private val adapter: PosterAdapter by lazy { PosterAdapter() }
    private var state: State = State.Expanded

    init {
        context.obtainStyledAttributes(attrs, R.styleable.StCollapsableSection).withRecycle {
            getString(R.styleable.StCollapsableSection_stcsTitle)?.also { setTitle(it) }
        }
        binding.stCollapsableSectionList.adapter = adapter
        adapter.submitList(listOf(
            true, true, true, true, true, true, true, true, false
        ))
        binding.stCollapsableSectionChevron.setOnClickListener {
            toggleListState()
        }
    }

    fun setTitle(title: String) {
        binding.stCollapsableSectionHeading.text = title
    }

    fun toggleListState() {
        when (state) {
            State.Collapsed -> expandList()
            State.Expanded -> collapseList()
        }
    }

    fun expandList() {
        state = State.Expanded
        toggleState()
    }

    fun collapseList() {
        state = State.Collapsed
        toggleState()
    }

    private fun toggleState() {
        when (state) {
            State.Collapsed -> {
                binding.stCollapsableSectionList.gone()
                binding.stCollapsableSectionChevron.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.chevron_down_24))
            }
            State.Expanded -> {
                binding.stCollapsableSectionList.visible()
                binding.stCollapsableSectionChevron.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.chevron_up_24))
            }
        }
    }

    sealed interface State {
        object Expanded: State
        object Collapsed: State
    }

}