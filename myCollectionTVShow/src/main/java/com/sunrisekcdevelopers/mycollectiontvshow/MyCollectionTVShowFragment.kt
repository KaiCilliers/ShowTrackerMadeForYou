package com.sunrisekcdevelopers.mycollectiontvshow

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.mycollectiontvshow.databinding.MyCollectionTvshowFragmentBinding
import com.sunrisekcdevelopers.navigation.GlobalDestinations
import com.sunrisekcdevelopers.navigation.SecondaryDestinations
import com.sunrisekcdevelopers.navigation.loadIntent
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class MyCollectionTVShowFragment : Fragment(R.layout.my_collection_tvshow_fragment) {
    private val binding: MyCollectionTvshowFragmentBinding by viewBinding(MyCollectionTvshowFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMyListTvShowLabel.setOnClickListener {
            // https://stackoverflow.com/questions/14850212/intent-and-start-activity-from-string
            startActivity(loadIntent(requireContext(), GlobalDestinations.Activities.SecondaryActivity).apply {
                putExtra(GlobalDestinations.KEYS.SECONDARY_INITIAL_DESTINATION, SecondaryDestinations.TVShowDetail)
            })
        }
    }
}