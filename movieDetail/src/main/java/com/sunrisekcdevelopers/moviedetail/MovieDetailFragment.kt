package com.sunrisekcdevelopers.moviedetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.sunrisekcdevelopers.common.R as commonR
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.moviedetail.databinding.MovieDetailFragmentBinding
import com.sunrisekcdevelopers.navigation.GlobalDestinations
import com.sunrisekcdevelopers.navigation.TransactionAnimations
import com.sunrisekcdevelopers.navigation.loadFragment
import com.sunrisekcdevelopers.navigation.replaceFragmentExt
import com.sunrisekcdevelopers.ui_components.components.StBanner
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.MediaQuickSummary
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding
import com.sunrisekcdevelopers.ui_components.visible

class MovieDetailFragment : Fragment(R.layout.movie_detail_fragment) {

    private val binding: MovieDetailFragmentBinding by viewBinding(MovieDetailFragmentBinding::bind)
    // needs koin injection
    private val viewModel: MovieDetailViewModelContract by viewModels<MovieDetailViewModel>()
    private val bottomTabHeadings: MutableList<String> = mutableListOf()

    // todo reference fragment's activity to set additional actions
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDiscoveryLabel.setOnClickListener {
            (loadFragment(GlobalDestinations.Fragments.EpisodeDetail) as BottomSheetDialogFragment).show(childFragmentManager, "EpisodeDetail")
        }
        binding.movieDetailBanner.setOnClickListener {
            replaceFragmentExt(
                newFragment = loadFragment(GlobalDestinations.Fragments.About),
                addToBackStack = true,
                transactionAnimations = TransactionAnimations.RIGHT_TO_LEFT
            )
        }
        binding.movieDetailTagline.setOnClickListener {
            replaceFragmentExt(
                newFragment = loadFragment(GlobalDestinations.Fragments.FreeSearch),
                addToBackStack = true,
                transactionAnimations = TransactionAnimations.RIGHT_TO_LEFT
            )
        }
        // todo determine which lifecycleowner to pass here
        viewModel.exampleState.observe(viewLifecycleOwner) {
            binding.apply {
                movieDetailMediaCoreDetails.submitModel(MediaQuickSummary.Movie(
                    id = it.id.toString(),
                    title = it.coreDetails.title,
                    posterUrl = it.coreDetails.posterPath,
                    directedBy = it.coreDetails.director,
                    year = it.coreDetails.releaseYear,
                    rating = it.coreDetails.rating
                ))
                it.banner?.message?.let { msg ->
                    movieDetailBanner.visible()
                    movieDetailBanner.setMessage(msg)
                    movieDetailBanner.showIcon()
                    movieDetailBanner.setIcon(StBanner.BannerIcon.Heart)
                }
                movieDetailTagline.text = "\"${it.tagline}\""
                movieDetailTagline.visible()
                movieDetailDescription.text = it.overview
                movieDetailGenres.setTags(it.genres)
                movieDetailLanguages.setTags(it.languages)
                movieDetailActionAdd.setOnClickListener { Toast.makeText(requireContext(), "Add", Toast.LENGTH_SHORT).show() }
                movieDetailActionRate.setOnClickListener { Toast.makeText(requireContext(), "Rate", Toast.LENGTH_SHORT).show() }
                movieDetailActionWatch.setOnClickListener { Toast.makeText(requireContext(), "Watch", Toast.LENGTH_SHORT).show() }
                movieDetailActionShare.setOnClickListener { Toast.makeText(requireContext(), "Share", Toast.LENGTH_SHORT).show() }
                StandardGlideImage()
                    .load(
                        requireContext(),
                        it.backdrop,
                        binding.movieDetailTrailer
                    )
            }
        }

        val adapter = MovieBottomViewPagerAdapter(this)
        binding.movieDetailBottomContainer.adapter = adapter
        bottomTabHeadings.addAll(arrayOf(
            getString(commonR.string.tab_heading_more_like_this),
            getString(commonR.string.tab_heading_cast)
        ))
        TabLayoutMediator(binding.movieDetailBottomTabs, binding.movieDetailBottomContainer) { tab, position ->
            tab.text = bottomTabHeadings[position]
        }.attach()
    }

}