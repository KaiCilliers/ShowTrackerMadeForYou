package com.sunrisekcdevelopers.showtracker.primary

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.showtracker.R
import com.sunrisekcdevelopers.showtracker.activities.SecondaryActivity
import com.sunrisekcdevelopers.showtracker.databinding.DiscoveryFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding
import kotlinx.android.parcel.Parcelize

class DiscoveryFragment  : Fragment(R.layout.discovery_fragment) {
    private val binding: DiscoveryFragmentBinding by viewBinding(DiscoveryFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDiscoveryLabel.setOnClickListener {
            val intent = Intent(requireContext(),  SecondaryActivity::class.java)
            intent.putExtra("fragment", SecondaryDestination.OnlyOne(99))
            startActivity(intent)
        }
    }
}

sealed class SecondaryDestination: Parcelable {
    @Parcelize data class OnlyOne(val i: Int) : SecondaryDestination()
    @Parcelize object Two : SecondaryDestination()
}