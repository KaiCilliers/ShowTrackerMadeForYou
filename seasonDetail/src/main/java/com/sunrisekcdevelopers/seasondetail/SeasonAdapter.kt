package com.sunrisekcdevelopers.seasondetail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunrisekcdevelopers.seasondetail.databinding.ViewholderSeasonBinding

class SeasonAdapter : ListAdapter<Int, SeasonAdapter.SeasonViewHolder>(COMPARATOR) {
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder = SeasonViewHolder.from(parent)
    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) = holder.bind(getItem(position))

    class SeasonViewHolder private constructor(
        private val binding: ViewholderSeasonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): SeasonViewHolder = SeasonViewHolder(
                ViewholderSeasonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
        fun bind(data: Int) {
            binding.viewholderSeason.setImage("https://image.tmdb.org/t/p/w780/dX4VVci4gy0H7bX1lq3N6Gsu4av.jpg")
            binding.viewholderSeason.setNumber(data)
        }
    }
}