package com.sunrisekcdevelopers.episodedetail

data class EpisodeDetailUiModel(
    val title: String,
    val backdropUrl: String,
    val season: Int,
    val episode: Int,
    val bannerMsg: String? = null,
    val overview: String
)