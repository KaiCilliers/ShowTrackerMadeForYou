package com.sunrisekcdevelopers.showtracker.primary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.showtracker.R
import com.sunrisekcdevelopers.showtracker.databinding.MyListMoviesFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class MyListMovieFragment : Fragment(R.layout.my_list_movies_fragment) {
    private val binding: MyListMoviesFragmentBinding by viewBinding(MyListMoviesFragmentBinding::bind)
}