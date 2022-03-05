package com.sunrisekcdevelopers.tvshowdetail.season

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sunrisekcdevelopers.tvshowdetail.cast.CastAdapter
import com.sunrisekcdevelopers.tvshowdetail.R
import com.sunrisekcdevelopers.tvshowdetail.databinding.TabContainerBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

/**
 * Display a list of all seasons associated with tv show
 * Used in conjunction with ViewPager
 */
class TabSeasonsAdapter : Fragment(R.layout.tab_container) {

    private val binding: TabContainerBinding by viewBinding(TabContainerBinding::bind)
    private val adapter: SeasonAdapter by lazy { SeasonAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        binding.tabCastList.layoutManager = LinearLayoutManager(requireContext())
        binding.tabCastList.adapter = adapter
        adapter.submitList((0..20).toList())
    }
}