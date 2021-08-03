package com.example.defilmsapp.ui.tvShow

import com.example.defilmsapp.ui.movies.MoviesViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel
    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val courseEntities = viewModel.getTvShow()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities.size)
    }
}