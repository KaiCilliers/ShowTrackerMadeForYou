package com.sunrisekcdevelopers.persondetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.sunrisekcdevelopers.persondetail.databinding.PersonDetailFragmentBinding
import com.sunrisekcdevelopers.ui_components.PosterAdapter
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class PersonDetailFragment : Fragment(R.layout.person_detail_fragment) {

    private val binding: PersonDetailFragmentBinding by viewBinding(PersonDetailFragmentBinding::bind)
    private val viewModel: PersonDetailViewModelContract by viewModels<PersonDetailViewModel>()
    private val bottomTabHeadings: MutableList<String> = mutableListOf()

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.someData.observe(viewLifecycleOwner) {
            binding.apply {
                personDetailCoreDetails.setPersonName(it.name)
                personDetailCoreDetails.setYob(it.yob)
                personDetailCoreDetails.setAddress(it.address)
                personDetailCoreDetails.setCountry(it.country)
                personDetailCoreDetails.setProfileImage(it.imageUrl)
                personDetailBioBody.text = it.bio
            }
        }
        val adapter = PersonDetailViewPagerAdapter(this)
        binding.personDetailBottomContainer.adapter = adapter
        bottomTabHeadings.addAll(arrayOf(
            getString(R.string.tab_heading_movie),
            getString(R.string.tab_heading_tv_show)
        ))
        TabLayoutMediator(binding.personDetailTabs, binding.personDetailBottomContainer) { tab, position ->
            tab.text = bottomTabHeadings[position]
        }.attach()
    }

}