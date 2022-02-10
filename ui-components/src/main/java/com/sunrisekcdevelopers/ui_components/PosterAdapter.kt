package com.sunrisekcdevelopers.ui_components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunrisekcdevelopers.ui_components.databinding.ViewholderPosterBinding

class PosterAdapter : ListAdapter<Int, PosterAdapter.PosterViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        return PosterViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        holder.bind()
    }

    class PosterViewHolder private constructor(
        val binding: ViewholderPosterBinding
    ) : RecyclerView.ViewHolder (binding.root) {

        fun bind() {
            binding.viewholderPoster.setImage(
                "https://th.bing.com/th/id/R.80c1f98b09c9277a05b5b7ff55570b84?rik=7Eqx5Zb6y%2fjZAA&riu=http%3a%2f%2fwww.bedlamfarm.com%2fwp-content%2fuploads%2f2017%2f07%2fPortrait-Gus.-A-Small-Dog-Is-Different-Than-A-Big-Dog-944x766.jpg&ehk=cSTzIadB1b0riJrmBTYMenvHaf3Wu491bPqs%2fSIkt58%3d&risl=&pid=ImgRaw&r=0"
            )
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
        private val COMPARATOR = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
                return oldItem == newItem
            }
        }
    }
}