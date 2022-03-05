package com.sunrisekcdevelopers.tvshowdetail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunrisekcdevelopers.tvshowdetail.cast.TabCastFragment
import com.sunrisekcdevelopers.tvshowdetail.morelikethis.TabMoreLikeThisFragment
import com.sunrisekcdevelopers.tvshowdetail.season.TabSeasonsAdapter

/**
 * Adapter for ViewPager at the bottom of layout
 * Used together with a TabLayout
 */
class BottomViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    companion object {
        private const val NUM_TABS = 3
    }

    override fun getItemCount(): Int = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabSeasonsAdapter()
            1 -> TabMoreLikeThisFragment()
            else -> TabCastFragment()
        }
    }
}