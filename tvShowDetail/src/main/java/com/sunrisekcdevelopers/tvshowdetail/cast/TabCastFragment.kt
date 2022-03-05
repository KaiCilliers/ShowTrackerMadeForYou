package com.sunrisekcdevelopers.tvshowdetail.cast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.sunrisekcdevelopers.tvshowdetail.R
import com.sunrisekcdevelopers.tvshowdetail.databinding.TabContainerBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

/**
 * Used to display a list of cast members
 * Used in conjunction with ViewPager
 */
class TabCastFragment : Fragment(R.layout.tab_container) {

    private val binding: TabContainerBinding by viewBinding(TabContainerBinding::bind)
    private val adapter: CastAdapter by lazy { CastAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        binding.tabCastList.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.tabCastList.adapter = adapter
        adapter.submitList((0..20).toList())
    }
}