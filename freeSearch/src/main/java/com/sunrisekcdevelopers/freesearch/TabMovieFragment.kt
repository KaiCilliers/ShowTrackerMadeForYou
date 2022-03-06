package com.sunrisekcdevelopers.freesearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.freesearch.databinding.TabPosterFragmentBinding
import com.sunrisekcdevelopers.ui_components.PosterAdapter
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class TabMovieFragment : Fragment(R.layout.tab_poster_fragment) {

    private val binding: TabPosterFragmentBinding by viewBinding(TabPosterFragmentBinding::bind)
    private val adapter: PosterAdapter by lazy { PosterAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        binding.tabPosterList.adapter = adapter
        adapter.submitList(listOf(
            true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
        ))
    }

}