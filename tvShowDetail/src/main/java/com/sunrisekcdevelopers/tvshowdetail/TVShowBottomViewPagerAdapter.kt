package com.sunrisekcdevelopers.tvshowdetail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunrisekcdevelopers.common.cast.TabCastFragment
import com.sunrisekcdevelopers.common.morelikethis.TabMoreLikeThisFragment
import com.sunrisekcdevelopers.tvshowdetail.season.TabSeasonsFragment

/**
 * Adapter for ViewPager at the bottom of layout
 * Used together with a TabLayout
 */
class TVShowBottomViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    companion object {
        private const val NUM_TABS = 3
    }

    override fun getItemCount(): Int = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabSeasonsFragment()
            1 -> TabMoreLikeThisFragment()
            else -> TabCastFragment()
        }
    }
}