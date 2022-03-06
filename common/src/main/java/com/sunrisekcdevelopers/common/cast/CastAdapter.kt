package com.sunrisekcdevelopers.common.cast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunrisekcdevelopers.common.cast.CastAdapter.CastViewHolder
import com.sunrisekcdevelopers.ui_components.components.StPoster
import com.sunrisekcdevelopers.ui_components.databinding.ViewholderCastBinding

/**
 * Adapter to display cast members of a movie or tv show
 */
class CastAdapter : ListAdapter<Int, CastViewHolder>(COMPARATOR){
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder{
        return CastViewHolder.from(parent)
    }
    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CastViewHolder private constructor(
        private val binding: ViewholderCastBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): CastViewHolder = CastViewHolder(
                ViewholderCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
        @Suppress("UNUSED_PARAMETER")
        fun bind(data: Int) {
            binding.castViewHolderPoster.apply {
                setImage("https://image.tmdb.org/t/p/w500/3bTVQH9vBXAiwGVHXKLylStz4RT.jpg")
                setCropTypeV2(StPoster.CropType.Circle)
                setIconPlacementV2(StPoster.IconPlacement.BottomRight)
            }
        }
    }
}