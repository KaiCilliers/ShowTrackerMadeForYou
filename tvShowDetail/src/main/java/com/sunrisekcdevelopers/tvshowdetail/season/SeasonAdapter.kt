package com.sunrisekcdevelopers.tvshowdetail.season

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunrisekcdevelopers.tvshowdetail.R
import com.sunrisekcdevelopers.tvshowdetail.databinding.SeasonViewHolderBinding
import com.sunrisekcdevelopers.ui_components.components.StPoster
import com.sunrisekcdevelopers.ui_components.components.StSeasonProgress

class SeasonAdapter : ListAdapter<Int, SeasonAdapter.SeasonViewHolder>(COMPARATOR) {
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder =
        SeasonViewHolder.from(parent)
    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) = holder.bind(getItem(position))

    class SeasonViewHolder private constructor(
        private val binding: SeasonViewHolderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup) = SeasonViewHolder(
                SeasonViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
        @Suppress("UNUSED_PARAMETER")
        fun bind(data: Int) {
            // todo again we have an unresolved reference when using binding... no idea why
            binding.root.findViewById<StSeasonProgress>(R.id.season_view_holder_season_progress).apply {
                setTitle("aldkjasdjakldasdjalkd")
                setMaxValue(55.0)
                setProgress(44.0)
                setPosterImage("https://image.tmdb.org/t/p/w500/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg")
                setBannerMessage("banner")
                showBanner()
            }
        }
    }
}