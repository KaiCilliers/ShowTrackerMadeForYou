package com.sunrisekcdevelopers.refinedsearch.multi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.sunrisekcdevelopers.refinedsearch.R
import com.sunrisekcdevelopers.refinedsearch.databinding.RefinedSearchMultiBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class RefinedSearchMultiFragment : Fragment(R.layout.refined_search_multi) {

    private val binding: RefinedSearchMultiBinding by viewBinding(RefinedSearchMultiBinding::bind)
    private val viewModel: RefinedSearchMultiViewModelContract by viewModels<RefinedSearchMultiViewModel>()
    private val tabHeadings: MutableList<String> by lazy { mutableListOf() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RefinedSearchMultiViewPagerAdapter(this)
        binding.refinedSearchMultiContainer.adapter = adapter
        tabHeadings.addAll(arrayOf(
            getString(R.string.tab_heading_movies),
            getString(R.string.tab_heading_tvshows)
        ))
        TabLayoutMediator(binding.refinedSearchMultiTabs, binding.refinedSearchMultiContainer) { tab, position ->
            tab.text = tabHeadings[position]
        }.attach()
    }

}