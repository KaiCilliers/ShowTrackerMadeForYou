package com.sunrisekcdevelopers.moviedetail

data class MovieDetailUiModel(
    val id: Int,
    val coreDetails: MovieCoreDetails,
    val backdrop: String,
    val banner: BannerUiModel?,
    val tagline: String,
    val overview: String,
    val genres: List<String>,
    val languages: List<String>
)

