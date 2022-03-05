package com.sunrisekcdevelopers.tvshowdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.tvshowdetail.databinding.TvshowDetailFragmentBinding
import com.sunrisekcdevelopers.tvshowdetail.viewpager.BottomViewPagerAdapter
import com.sunrisekcdevelopers.ui_components.components.StBanner
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.MediaQuickSummary
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.TVShowStatus
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding
import com.sunrisekcdevelopers.ui_components.visible

class TVShowDetailFragment : Fragment(R.layout.tvshow_detail_fragment) {

    private val binding: TvshowDetailFragmentBinding by viewBinding(TvshowDetailFragmentBinding::bind)
    private val viewModel: TVShowDetailViewModelContract by viewModels<TVShowDetailViewModel>()
    private val bottomTabHeadings: MutableList<String> = mutableListOf()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) {
            binding.apply {
                binding.tvshowDetailMediaCoreDetails.submitModel(
                    MediaQuickSummary.TVShow(
                        id = it.id.toString(),
                        title = it.coreDetails.title,
                        posterUrl = it.coreDetails.posterPath,
                        directedBy = it.coreDetails.director,
                        year = it.coreDetails.releaseYear,
                        rating = it.coreDetails.rating,
                        status = TVShowStatus.RETURNING_SERIES
                    )
                )
                it.banner?.message?.let { msg ->
                    tvshowDetailBanner.visible()
                    tvshowDetailBanner.setMessage(msg)
                    tvshowDetailBanner.showIcon()
                    tvshowDetailBanner.setIcon(StBanner.BannerIcon.Heart)
                }
                tvshowDetailTagline.text = "\"${it.tagline}\""
                tvshowDetailTagline.visible()
                tvshowDetailDescription.text = it.overview
                tvshowDetailGenres.setTags(it.genres)
                tvshowDetailLanguages.setTags(it.languages)
                tvshowDetailActionAdd.setOnClickListener { Toast.makeText(requireContext(), "Add", Toast.LENGTH_SHORT).show() }
                tvshowDetailActionRate.setOnClickListener { Toast.makeText(requireContext(), "Rate", Toast.LENGTH_SHORT).show() }
                tvshowDetailActionShare.setOnClickListener { Toast.makeText(requireContext(), "Share", Toast.LENGTH_SHORT).show() }
                StandardGlideImage()
                    .load(
                        requireContext(),
                        it.backdropPath,
                        tvshowDetailTrailer
                    )
            }
        }
        val adapter = BottomViewPagerAdapter(this)
        binding.tvshowDetailBottomContainer.adapter = adapter
        bottomTabHeadings.addAll(arrayOf(
            getString(R.string.tab_heading_episodes),
            getString(R.string.tab_heading_more_like_this),
            getString(R.string.tab_heading_cast)
        ))
        TabLayoutMediator(binding.tvshowDetailBottomTabs, binding.tvshowDetailBottomContainer) { tab, position ->
            tab.text = bottomTabHeadings[position]
        }.attach()
    }

}