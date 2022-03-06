package com.sunrisekcdevelopers.ui_components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunrisekcdevelopers.ui_components.databinding.ViewholderPosterBinding

class PosterAdapter : ListAdapter<Boolean, PosterAdapter.PosterViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        return PosterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PosterViewHolder private constructor(
        val binding: ViewholderPosterBinding
    ) : RecyclerView.ViewHolder (binding.root) {

        fun bind(data: Boolean) {
            if (data) {
                binding.viewholderPoster.setImage("https://image.tmdb.org/t/p/w500/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg")
            } else {
                binding.viewholderPoster.setImage("https://image.tmdb.org/t/p/w500/tUkY0WxffPZ9PoyC62PIyyUMGnt.jpg")
            }
        }

        companion object {
            fun from(parent: ViewGroup): PosterViewHolder {
                return PosterViewHolder(
                    ViewholderPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Boolean>() {
            override fun areItemsTheSame(oldItem: Boolean, newItem: Boolean): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Boolean, newItem: Boolean): Boolean {
                return oldItem == newItem
            }
        }
    }
}