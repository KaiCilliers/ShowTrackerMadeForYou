package com.sunrisekcdevelopers.mycollectionmovie

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.mycollectionmovie.databinding.MyCollectionMovieFragmentBinding
import com.sunrisekcdevelopers.navigation.GlobalDestinations
import com.sunrisekcdevelopers.navigation.loadIntent
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class MyCollectionMovieFragment : Fragment(R.layout.my_collection_movie_fragment) {
    private val binding: MyCollectionMovieFragmentBinding by viewBinding(MyCollectionMovieFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMyListMovieLabel.setOnClickListener {
            // https://stackoverflow.com/questions/14850212/intent-and-start-activity-from-string
            startActivity(loadIntent(requireContext(), GlobalDestinations.Activities.SecondaryActivity))
        }
    }
}