package com.sunrisekcdevelopers.ui_components.components.st_media_core_details

sealed class MediaQuickSummary {
    abstract val id: String
    abstract val title: String
    abstract val posterUrl: String
    abstract val directedBy: String
    abstract val rating: Float
    abstract val year: String

    data class Movie(
        override val id: String,
        override val title: String,
        override val posterUrl: String,
        override val directedBy: String,
        override val year: String = "",
        override val rating: Float = Float.MIN_VALUE,
        val runtime: Float = Float.MIN_VALUE
    ) : MediaQuickSummary()

    data class TVShow(
        override val id: String,
        override val title: String,
        override val posterUrl: String,
        override val directedBy: String,
        override val year: String = "",
        override val rating: Float = Float.MIN_VALUE,
        val status: TVShowStatus
    ): MediaQuickSummary()
}