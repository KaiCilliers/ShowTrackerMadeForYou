package com.sunrisekcdevelopers.ui_components.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.ui_components.databinding.StShowWatchProgressItemBinding

// todo swipe left and right (idk if this should be done on the custom view or recyclerview)
// todo undo support :) there is a design pattern for that somewhere
class StShowWatchProgressItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StShowWatchProgressItemBinding = StShowWatchProgressItemBinding.inflate(LayoutInflater.from(context), this)

    private var currentEpisode = INVALID_EPISODE
    private var totalEpisodes = INVALID_EPISODE
    private var currentState: WatchItemState = WatchItemState.InProgress

    companion object {
        const val INVALID_EPISODE = -1
        const val ZERO_VALUE = 0
    }

    init {
        binding.stShowWatchProgressItemProgressIndicator.setOnCheckClickListener {
            when (it) {
                StProgressBar.CheckMarkState.Off -> {
                    currentEpisode = ZERO_VALUE
                    currentState = WatchItemState.InProgress
                }
                StProgressBar.CheckMarkState.On -> {
                    currentEpisode = totalEpisodes
                    currentState = WatchItemState.Complete
                }
            }
            binding.stShowWatchProgressItemProgressIndicator.setData(currentEpisode.toDouble(), totalEpisodes.toDouble())
            updateActionIcon()
        }
    }

    fun setSeasonTitle(title: String) {
        binding.stShowWatchProgressItemTitle.text = title
    }

    fun setEpisodeTitle(title: String) {
        binding.stShowWatchProgressItemEpisode.text = title
    }

    fun setSeasonData(currentEpisode: Int, episodesInSeason: Int) {
        this.currentEpisode = currentEpisode
        totalEpisodes = episodesInSeason
        binding.stShowWatchProgressItemProgressIndicator.setData(currentEpisode.toDouble(), episodesInSeason.toDouble())
    }

    // https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e
    fun setSeasonPoster(url: String) {
        binding.stShowWatchProgressItemPoster.setImage(url)
    }

    fun setOnActionIconClickListener(action: View.() -> Unit) {
        binding.stShowWatchProgressItemActionIcon.setOnClickListener {
            if (currentState == WatchItemState.InProgress) {
                action(it)
            }
            if (currentEpisode >= totalEpisodes) {
                currentState = WatchItemState.Complete
            }
            updateActionIcon()
        }
    }

    private fun updateActionIcon() {
        // update icon drawable and either remove onclicklistener or disable
        when (currentState) {
            WatchItemState.Complete -> {
                binding.stShowWatchProgressItemActionIcon.isEnabled = false
            }
            WatchItemState.InProgress -> {
                binding.stShowWatchProgressItemActionIcon.isEnabled = true
            }
        }
    }

    fun getCurrentProgress(): Int = currentEpisode

    sealed interface WatchItemState {
        object InProgress : WatchItemState
        object Complete : WatchItemState
    }

}