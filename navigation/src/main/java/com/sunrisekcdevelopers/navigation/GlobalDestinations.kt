package com.sunrisekcdevelopers.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Single location to store fully qualified names for views
 * Used when navigating using reflection
 */
object GlobalDestinations {
    private const val ROOT_PACKAGE = "com.sunrisekcdevelopers"
    object Activities {
        const val SecondaryActivity = "$ROOT_PACKAGE.showtracker.SecondaryActivity"
    }
    object Fragments {
        const val MovieDetail = "$ROOT_PACKAGE.moviedetail.MovieDetailFragment"
        const val EpisodeDetail = "$ROOT_PACKAGE.episodedetail.EpisodeDetailBottomSheet"
        const val TVShowDetail = "$ROOT_PACKAGE.tvshowdetail.TVShowDetailFragment"
        const val PersonDetail = "$ROOT_PACKAGE.persondetail.PersonDetailFragment"
        const val SeasonDetail = "$ROOT_PACKAGE.seasondetail.SeasonDetailFragment"
        const val About = "$ROOT_PACKAGE.about.AboutFragment"
        const val FreeSearch = "$ROOT_PACKAGE.freesearch.FreeSearchFragment"
        const val RefinesSearchSingle = "$ROOT_PACKAGE.refinedsearch.single.RefinedSearchSingleFragment"
        const val RefinesSearchMulti = "$ROOT_PACKAGE.refinedsearch.multi.RefinedSearchMultiFragment"
    }
    object KEYS {
        const val SECONDARY_INITIAL_DESTINATION = "secondary_destiantion"
    }
}

sealed interface SecondaryDestinations : Parcelable {
    @Parcelize object MovieDetail : SecondaryDestinations, Parcelable
    @Parcelize object EpisodeDetail : SecondaryDestinations, Parcelable
    @Parcelize object TVShowDetail : SecondaryDestinations, Parcelable
}