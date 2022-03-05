package com.sunrisekcdevelopers.tvshowdetail.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BottomViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    companion object {
        private const val NUM_TABS = 3
    }

    override fun getItemCount(): Int = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabEpisodesFragment()
            1 -> TabMoreLikeThisFragment()
            else -> TabCastFragment()
        }
    }
}