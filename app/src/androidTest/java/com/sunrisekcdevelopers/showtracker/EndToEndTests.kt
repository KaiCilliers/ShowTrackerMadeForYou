package com.sunrisekcdevelopers.showtracker

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sunrisekcdevelopers.showtracker.activities.PrimaryActivity

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EndToEndTests {

    @Test
    fun showDiscoveryAsInitialDestination() {
        ActivityScenario.launch(PrimaryActivity::class.java)
        onView(withContentDescription("Discovery")).check(matches(isDisplayed()))
    }

    @Test
    fun tapAndShowMyListMovieTab() {
        // Starts on Discovery as first screen
        ActivityScenario.launch(PrimaryActivity::class.java)
        onView(withId(R.id.nav_feature_my_list_movie)).perform(click())
        onView(withContentDescription("MyListMovie")).check(matches(isDisplayed()))
    }

    @Test
    fun tapAndShowMyListTVShowTab() {
        // Starts on Discovery as first screen
        ActivityScenario.launch(PrimaryActivity::class.java)
        onView(withId(R.id.nav_feature_my_list_tv_show)).perform(click())
        onView(withContentDescription("MyListTVShow")).check(matches(isDisplayed()))
    }

    @Test
    fun tapAndShowDiscoveryTab() {
        // Starts on Discovery as first screen
        ActivityScenario.launch(PrimaryActivity::class.java)
        onView(withId(R.id.nav_feature_discovery)).perform(click())
        onView(withContentDescription("Discovery")).check(matches(isDisplayed()))
    }
}