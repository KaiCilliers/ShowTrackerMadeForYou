package com.sunrisekcdevelopers.about

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.about.databinding.AboutFragmentBinding
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class AboutFragment : Fragment(R.layout.about_fragment) {

    private val binding: AboutFragmentBinding by viewBinding(AboutFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        StandardGlideImage().load(
            requireContext(),
            "https://upload.wikimedia.org/wikipedia/commons/6/6e/Tmdb-312x276-logo.png",
            binding.aboutImage
        )
    }

}