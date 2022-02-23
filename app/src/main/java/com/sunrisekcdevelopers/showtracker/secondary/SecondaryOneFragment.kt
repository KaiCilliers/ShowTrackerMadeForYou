package com.sunrisekcdevelopers.showtracker.secondary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.navigation.TransactionAnimations
import com.sunrisekcdevelopers.navigation.replaceFragmentExt
import com.sunrisekcdevelopers.showtracker.R
import com.sunrisekcdevelopers.showtracker.databinding.SecondaryOneFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class SecondaryOneFragment : Fragment(R.layout.secondary_one_fragment) {
    private val binding: SecondaryOneFragmentBinding by viewBinding(SecondaryOneFragmentBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.secondaryOneLabel.setOnClickListener {
            replaceFragmentExt(
                newFragment = SecondaryTwoFragment(),
                addToBackStack = true,
                transactionAnimations = TransactionAnimations.RIGHT_TO_LEFT
            )
        }
    }
}