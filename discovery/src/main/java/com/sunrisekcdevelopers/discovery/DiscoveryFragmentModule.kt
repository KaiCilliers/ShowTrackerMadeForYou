package com.sunrisekcdevelopers.discovery

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.discovery.databinding.DiscoveryFragmentExtBinding
import com.sunrisekcdevelopers.navigation.GlobalDestinations
import com.sunrisekcdevelopers.navigation.SecondaryDestinations
import com.sunrisekcdevelopers.navigation.loadIntent
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class DiscoveryFragmentModule : Fragment(R.layout.discovery_fragment_ext) {

    private val binding: DiscoveryFragmentExtBinding by viewBinding(DiscoveryFragmentExtBinding::bind)

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDiscoveryLabel.setOnClickListener {
            // https://stackoverflow.com/questions/14850212/intent-and-start-activity-from-string
            startActivity(loadIntent(requireContext(), GlobalDestinations.Activities.SecondaryActivity).apply {
                putExtra(GlobalDestinations.KEYS.SECONDARY_INITIAL_DESTINATION, SecondaryDestinations.EpisodeDetail)
            })
        }
    }
}