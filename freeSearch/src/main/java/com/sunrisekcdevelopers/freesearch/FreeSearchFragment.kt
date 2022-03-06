package com.sunrisekcdevelopers.freesearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.sunrisekcdevelopers.freesearch.databinding.FreeSearchFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class FreeSearchFragment : Fragment(R.layout.free_search_fragment) {

    private val binding: FreeSearchFragmentBinding by viewBinding(FreeSearchFragmentBinding::bind)
    private val viewModel: FreeSearchViewModelContract by viewModels<FreeSearchViewModel>()
    private val tabHeadings: MutableList<String> by lazy { mutableListOf() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabHeadings.addAll(arrayOf(
            getString(R.string.heading_movies),
            getString(R.string.heading_tvshows),
            getString(R.string.heading_people)
        ))
        val adapter = FreeSearchViewPagerAdapter(this)
        binding.freeSearchContainer.adapter = adapter
        TabLayoutMediator(binding.freeSearchTabs, binding.freeSearchContainer) { tab, position ->
            tab.text = tabHeadings[position]
        }.attach()
        viewModel.someData.observe(viewLifecycleOwner) {

        }
    }

}