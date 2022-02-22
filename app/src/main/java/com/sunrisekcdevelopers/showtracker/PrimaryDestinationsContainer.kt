package com.sunrisekcdevelopers.showtracker

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.showtracker.databinding.PrimaryDestinationFragmentContainerBinding
import com.sunrisekcdevelopers.showtracker.primary.MyListMovieFragment
import com.sunrisekcdevelopers.showtracker.primary.DiscoveryFragment
import com.sunrisekcdevelopers.showtracker.primary.MyListTVShowFragment
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class PrimaryDestinationsContainer : Fragment(R.layout.primary_destination_fragment_container) {

    private val binding: PrimaryDestinationFragmentContainerBinding by viewBinding(PrimaryDestinationFragmentContainerBinding::bind)

    // Here you place variables for each fragment in navhost destinations
    private val myListMovieFragment: MyListMovieFragment by lazy { MyListMovieFragment() }
    private val myListTVShowFragment: MyListTVShowFragment by lazy { MyListTVShowFragment() }
    private val discoveryFragment: DiscoveryFragment by lazy { DiscoveryFragment() }

    private val destinationList: Map<String, Fragment> by lazy {
        mapOf(
            "MyListMovieFragment" to myListMovieFragment,
            "MyListTVShowFragment" to myListTVShowFragment,
            START_DESTINATION to discoveryFragment
        )
    }

    private companion object {
        private const val START_DESTINATION = "DiscoveryFragment"
    }

    // Current active fragment, there should always be a tab selected
    private var activeFragment: Fragment = discoveryFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            addFragments()
            setupBottomNav()
        }
    }

    /**
     * Add primary destination fragments to [getChildFragmentManager] if not already present
     */
    private fun addFragments() {
        if (childFragmentManager.fragments.isEmpty()) {
            activeFragment = discoveryFragment

            // Add fragments to the FragmentContainer
            childFragmentManager.beginTransaction().apply {
                destinationList.forEach {
                    add(R.id.primary_fragment_container, it.value)
                    if (it.key != START_DESTINATION) {
                        hide(it.value)
                    }
                }
                commit()
            }
        }
    }

    /**
     * Set what fragments to show when a tab is clicked
     */
    private fun setupBottomNav() {
        binding.primaryFragmentBottomNav.apply {
            setOnItemSelectedListener { item ->
                return@setOnItemSelectedListener when (item.itemId) {
                    R.id.nav_feature_my_list_movie -> {
                        switchToTab(myListMovieFragment)
                        true
                    }
                    R.id.nav_feature_my_list_tv_show -> {
                        switchToTab(myListTVShowFragment)
                        true
                    }
                    R.id.nav_feature_discovery -> {
                        switchToTab(discoveryFragment)
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
            selectedItemId = R.id.nav_feature_discovery
        }
    }

    /**
     * Use fragment manager to hide current fragment and show [tab]
     */
    private fun switchToTab(tab: Fragment) {
        childFragmentManager.beginTransaction()
            .hide(activeFragment)
            .show(tab)
            .commit()
        activeFragment = tab
    }

}