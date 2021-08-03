package com.example.defilmsapp.ui.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel
    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val courseEntities = viewModel.getMovies()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities.size)
    }
}