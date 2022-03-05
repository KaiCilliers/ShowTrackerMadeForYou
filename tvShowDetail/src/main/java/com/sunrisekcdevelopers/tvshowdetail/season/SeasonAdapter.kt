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
                setPosterImage("https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e")
                setBannerMessage("banner")
                showBanner()
            }
        }
    }
}