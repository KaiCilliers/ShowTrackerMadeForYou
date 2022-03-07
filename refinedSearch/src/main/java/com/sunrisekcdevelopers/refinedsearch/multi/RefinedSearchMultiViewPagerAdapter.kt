package com.sunrisekcdevelopers.refinedsearch.multi

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunrisekcdevelopers.refinedsearch.TabPosterFragment

class RefinedSearchMultiViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    companion object {
        private const val NUM_TABS = 2
    }

    override fun getItemCount(): Int = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return TabPosterFragment()
    }
}