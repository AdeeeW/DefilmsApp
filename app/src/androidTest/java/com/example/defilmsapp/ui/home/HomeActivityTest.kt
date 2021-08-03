package com.example.defilmsapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.idling.CountingIdlingResource
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.defilmsapp.R
import com.example.defilmsapp.utils.Data
import org.hamcrest.CoreMatchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = Data.generateDataMovies()
    private val dummyTvShow = Data.generateDataTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                7,
                click()
            )
        )
        onView(withId(R.id.tv_detail_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_judul)).check(matches(withText(dummyMovie[7].judulMovie)))
        onView(withId(R.id.tv_detail_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_status)).check(matches(withText(dummyMovie[7].status)))
        onView(withId(R.id.tv_detail_bahasa)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_bahasa)).check(matches(withText(dummyMovie[7].bahasa)))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyMovie[7].genre)))
        onView(withId(R.id.tv_detail_durasi)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_durasi)).check(matches(withText(dummyMovie[7].durasi)))
        onView(withId(R.id.tv_detail_deskripsi)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_deskripsi)).check(matches(withText(dummyMovie[7].description)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                8,
                click()
            )
        )
        onView(withId(R.id.tv_detail_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_judul)).check(matches(withText(dummyTvShow[8].judulTvShow)))
        onView(withId(R.id.tv_detail_status)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_status)).check(matches(withText(dummyTvShow[8].status)))
        onView(withId(R.id.tv_detail_bahasa)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_bahasa)).check(matches(withText(dummyTvShow[8].bahasa)))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyTvShow[8].genre)))
        onView(withId(R.id.tv_detail_episode)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_episode)).check(matches(withText(dummyTvShow[8].jumlahEpisod)))
        onView(withId(R.id.tv_detail_jenis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_jenis)).check(matches(withText(dummyTvShow[8].jenis)))
        onView(withId(R.id.tv_detail_deskripsi)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_deskripsi)).check(matches(withText(dummyTvShow[8].description)))
    }

    @Test
    fun loadViewPagerMovie() {
        onView(allOf(
            withId(R.id.view_pager)
        )).check(matches(isDisplayed()))
            .perform(swipeLeft())
    }

    @Test
    fun loadViewPagerTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(allOf(
            withId(R.id.view_pager)
        )).check(matches(isDisplayed()))
            .perform(swipeRight())
    }
}