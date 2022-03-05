package com.sunrisekcdevelopers.common.morelikethis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunrisekcdevelopers.common.morelikethis.MoreLikeThisAdapter.MoreLikeThisViewHolder
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.components.StPoster
import com.sunrisekcdevelopers.ui_components.databinding.ViewholderMoreLikeThisBinding

/**
 * Adapter to display media similar to the current movie or tv show details are being displayed
 */
class MoreLikeThisAdapter : ListAdapter<Int, MoreLikeThisViewHolder>(COMPARATOR) {
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreLikeThisViewHolder = MoreLikeThisViewHolder.from(parent)
    override fun onBindViewHolder(holder: MoreLikeThisViewHolder, position: Int) = holder.bind(getItem(position))

    class MoreLikeThisViewHolder private constructor(
        private val binding: ViewholderMoreLikeThisBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): MoreLikeThisViewHolder = MoreLikeThisViewHolder(
                ViewholderMoreLikeThisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
        @Suppress("UNUSED_PARAMETER")
        fun bind(data: Int) {
            // todo fix bug
//            binding.moreLikeThisViewHolderPoster gives unresolved reference error
            binding.root.findViewById<StPoster>(R.id.more_like_this_view_holder_poster)?.apply {
                setImage("https://image.tmdb.org/t/p/w500/aq4Pwv5Xeuvj6HZKtxyd23e6bE9.jpg")
                setCropTypeV2(StPoster.CropType.Poster)
                setIconPlacementV2(StPoster.IconPlacement.BottomRight)
            }
        }
    }
}