package com.sunrisekcdevelopers.refinedsearch.single

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.sunrisekcdevelopers.refinedsearch.R
import com.sunrisekcdevelopers.refinedsearch.databinding.RefinedSearchSingleBinding
import com.sunrisekcdevelopers.ui_components.PosterAdapter
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class RefinedSearchSingleFragment : Fragment(R.layout.refined_search_single) {

    private val binding: RefinedSearchSingleBinding by viewBinding(RefinedSearchSingleBinding::bind)
    private val viewModel: RefinedSearchSingleViewModelContract by viewModels<RefinedSearchSingleViewModel>()
    private val adapter: PosterAdapter by lazy { PosterAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.refinedSearchSingleList.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.refinedSearchSingleList.adapter = adapter
        adapter.submitList(listOf(
            false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false
        ))
    }

}