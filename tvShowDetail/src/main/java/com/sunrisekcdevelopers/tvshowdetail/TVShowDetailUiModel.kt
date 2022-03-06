package com.sunrisekcdevelopers.tvshowdetail

data class TVShowDetailUiModel(
    val id: Int,
    val coreDetails: TVShowCoreDetails,
    val banner: BannerUi?,
    val overview: String,
    val genres: List<String>,
    val languages: List<String>,
    val tagline: String,
    val backdropPath: String
)