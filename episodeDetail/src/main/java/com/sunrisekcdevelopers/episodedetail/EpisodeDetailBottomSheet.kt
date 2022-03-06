package com.sunrisekcdevelopers.episodedetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sunrisekcdevelopers.episodedetail.databinding.EpisodeDetailBottomsheetBinding
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.ui_components.components.StBanner

class EpisodeDetailBottomSheet : BottomSheetDialogFragment() {

    // todo viewbinding delegate does not work with bottomsheet - the sheet isnt displayed, but the backgroudn goes grey
    private lateinit var binding: EpisodeDetailBottomsheetBinding
    private val viewModel: EpisodeDetailViewModelContract by viewModels<EpisodeDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EpisodeDetailBottomsheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.someData.observe(viewLifecycleOwner) {
            binding.apply {
                StandardGlideImage().load(
                    requireContext(),
                    it.backdropUrl,
                    episodeDetailBackdrop
                )
                episodeDetailTitle.text = it.title
                episodeDetailCurrentSeasonEpisode.text = "S0${it.season}E0${it.episode}"
                episodeDetailBanner.setMessage(it.bannerMsg!!)
                episodeDetailBanner.setIcon(StBanner.BannerIcon.Share)
                episodeDetailActionWatch.setOnClickListener { Toast.makeText(requireContext(), "Yes, you pressed?", Toast.LENGTH_SHORT).show() }
                episodeDetailOverview.text = it.overview
            }
        }
    }

}
