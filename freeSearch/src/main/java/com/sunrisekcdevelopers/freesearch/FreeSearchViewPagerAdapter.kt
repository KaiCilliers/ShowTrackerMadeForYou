package com.sunrisekcdevelopers.freesearch

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FreeSearchViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    companion object {
        private const val NUM_TABS = 3
    }

    override fun getItemCount(): Int = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> TabMovieFragment()
            1 -> TabTVShowFragment()
            else -> TabPeopleFragment()
        }
    }
}