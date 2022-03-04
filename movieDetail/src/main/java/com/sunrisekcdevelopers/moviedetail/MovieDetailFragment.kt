package com.sunrisekcdevelopers.moviedetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.moviedetail.databinding.MovieDetailFragmentBinding
import com.sunrisekcdevelopers.navigation.GlobalDestinations
import com.sunrisekcdevelopers.navigation.TransactionAnimations
import com.sunrisekcdevelopers.navigation.loadFragment
import com.sunrisekcdevelopers.navigation.replaceFragmentExt
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class MovieDetailFragment : Fragment(R.layout.movie_detail_fragment) {

    private val binding: MovieDetailFragmentBinding by viewBinding(MovieDetailFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDiscoveryLabel.setOnClickListener {
            replaceFragmentExt(
                newFragment = loadFragment(GlobalDestinations.Fragments.EpisodeDetail),
                addToBackStack = true,
                transactionAnimations = TransactionAnimations.RIGHT_TO_LEFT
            )
        }
    }

}