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

data class MovieCoreDetails(
    val posterPath: String,
    val title: String,
    val releaseYear: String,
    val director: String,
    val runtime: Int,
    val rating: Float
)

data class BannerUiModel(
    val message: String
)