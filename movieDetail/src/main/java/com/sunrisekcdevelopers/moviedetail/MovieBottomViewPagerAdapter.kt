package com.sunrisekcdevelopers.moviedetail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunrisekcdevelopers.common.cast.TabCastFragment
import com.sunrisekcdevelopers.common.morelikethis.TabMoreLikeThisFragment

class MovieBottomViewPagerAdapter (
    fragment: Fragment
    ) : FragmentStateAdapter(fragment) {

        companion object {
            private const val NUM_TABS = 2
        }

        override fun getItemCount(): Int = NUM_TABS

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> TabMoreLikeThisFragment()
                else -> TabCastFragment()
            }
        }
    }