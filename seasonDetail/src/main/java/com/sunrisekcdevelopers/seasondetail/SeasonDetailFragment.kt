package com.sunrisekcdevelopers.seasondetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sunrisekcdevelopers.seasondetail.databinding.SeasonDetailFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class SeasonDetailFragment : Fragment(R.layout.season_detail_fragment) {

    private val binding: SeasonDetailFragmentBinding by viewBinding(SeasonDetailFragmentBinding::bind)
    private val viewModel: SeasonDetailViewModelContract by viewModels<SeasonDetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.someData.observe(viewLifecycleOwner) {
            binding.seasonDetailProgress.setData(14.0, 32.0)
            val adapter = SeasonAdapter()
            binding.seasonDetailList.adapter = adapter
            adapter.submitList((1..42).toList())
        }
    }

}