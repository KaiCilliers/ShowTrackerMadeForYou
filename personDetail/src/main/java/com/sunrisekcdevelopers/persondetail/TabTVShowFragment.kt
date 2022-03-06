package com.sunrisekcdevelopers.persondetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.sunrisekcdevelopers.ui_components.PosterAdapter
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.TabListContainerBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class TabTVShowFragment : Fragment(R.layout.tab_list_container) {

        private val binding: TabListContainerBinding by viewBinding(TabListContainerBinding::bind)
        private val adapter: PosterAdapter by lazy { PosterAdapter() }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            setupList()
        }

        private fun setupList() {
            binding.tabCastList.layoutManager = GridLayoutManager(requireContext(), 3)
            binding.tabCastList.adapter = adapter
            adapter.submitList(listOf(
                true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
            ))
        }

    }