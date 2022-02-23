package com.sunrisekcdevelopers.showtracker.primary

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.showtracker.R
import com.sunrisekcdevelopers.showtracker.activities.SecondaryActivity
import com.sunrisekcdevelopers.showtracker.databinding.MyListMoviesFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class MyListMovieFragment : Fragment(R.layout.my_list_movies_fragment) {
    private val binding: MyListMoviesFragmentBinding by viewBinding(MyListMoviesFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMyListMovieLabel.setOnClickListener {
            val intent = Intent(requireContext(), SecondaryActivity::class.java)
            intent.putExtra("fragment", SecondaryDestination.Two)
            startActivity(intent)
        }
    }
}