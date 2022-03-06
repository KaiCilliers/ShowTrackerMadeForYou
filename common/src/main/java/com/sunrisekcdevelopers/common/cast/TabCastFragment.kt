package com.sunrisekcdevelopers.common.cast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.sunrisekcdevelopers.navigation.GlobalDestinations
import com.sunrisekcdevelopers.navigation.loadFragment
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.TabListContainerBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

/**
 * Used to display a list of cast members
 * Used in conjunction with ViewPager
 */
class TabCastFragment : Fragment(R.layout.tab_list_container) {

    private val binding: TabListContainerBinding by viewBinding(TabListContainerBinding::bind)
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