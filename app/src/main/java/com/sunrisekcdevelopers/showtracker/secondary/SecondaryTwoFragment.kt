package com.sunrisekcdevelopers.showtracker.secondary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.navigation.popUntil
import com.sunrisekcdevelopers.showtracker.R
import com.sunrisekcdevelopers.showtracker.databinding.SecondaryTwoFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class SecondaryTwoFragment : Fragment(R.layout.secondary_two_fragment) {
    private val binding: SecondaryTwoFragmentBinding by viewBinding(SecondaryTwoFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.secondaryTwoLabel.setOnClickListener {
            popUntil(this::class.java.simpleName)
        }
    }
}