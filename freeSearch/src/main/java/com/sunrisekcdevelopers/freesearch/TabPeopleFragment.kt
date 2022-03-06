package com.sunrisekcdevelopers.freesearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.common.cast.CastAdapter
import com.sunrisekcdevelopers.freesearch.databinding.TabPeopleFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class TabPeopleFragment : Fragment(R.layout.tab_people_fragment) {

    private val binding: TabPeopleFragmentBinding by viewBinding(TabPeopleFragmentBinding::bind)
    private val adapter: CastAdapter by lazy { CastAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupList() {
        binding.tabPeopleList.adapter = adapter
        adapter.submitList((0..32).toList())
    }

}