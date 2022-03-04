package com.sunrisekcdevelopers.showtracker.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.navigation.GlobalDestinations
import com.sunrisekcdevelopers.navigation.R.id as rootAppResource
import com.sunrisekcdevelopers.navigation.SecondaryDestinations
import com.sunrisekcdevelopers.navigation.loadFragment
import com.sunrisekcdevelopers.showtracker.databinding.SecondaryActivityBinding
import com.sunrisekcdevelopers.showtracker.secondary.SecondaryOneFragment
import com.sunrisekcdevelopers.showtracker.secondary.SecondaryTwoFragment
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class SecondaryActivity : AppCompatActivity() {

    private val binding: SecondaryActivityBinding by viewBinding(SecondaryActivityBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        intent.getParcelableExtra<SecondaryDestinations>(GlobalDestinations.KEYS.SECONDARY_INITIAL_DESTINATION)?.also {
            val frag = when(it) {
                SecondaryDestinations.EpisodeDetail -> loadFragment(GlobalDestinations.Fragments.EpisodeDetail).apply {
                    arguments = Bundle().apply { putInt("some", 1) }
                }
                SecondaryDestinations.MovieDetail -> loadFragment(GlobalDestinations.Fragments.MovieDetail).apply {
                    arguments = Bundle().apply { putInt("some", 1) }
                }
                SecondaryDestinations.TVShowDetail -> loadFragment(GlobalDestinations.Fragments.TVShowDetail).apply {
                    arguments = Bundle().apply { putInt("some", 1) }
                }
            }
            supportFragmentManager.beginTransaction()
                .add(com.sunrisekcdevelopers.navigation.R.id.root_container, frag)
                .commit()
        } ?: finishActivity(0)
    }

}