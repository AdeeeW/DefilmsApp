package com.example.defilmsapp.ui.detailMovies

import com.example.defilmsapp.utils.Data
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMoviesViewModelTest {
    private lateinit var viewModel: DetailMoviesViewModel
    private val dummyMovie = Data.generateDataMovies()[0]
    private val movieId = dummyMovie.moviesId

    @Before
    fun setUp() {
        viewModel = DetailMoviesViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.moviesId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.imagePosterMovies, movieEntity.imagePosterMovies)
        assertEquals(dummyMovie.bahasa, movieEntity.bahasa)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.durasi, movieEntity.durasi)
        assertEquals(dummyMovie.judulMovie, movieEntity.judulMovie)
        assertEquals(dummyMovie.status, movieEntity.status)
        assertEquals(dummyMovie.tanggalRilis, movieEntity.tanggalRilis)
        assertEquals(dummyMovie.genre, movieEntity.genre)
    }

    @Test
    fun getDetailMovie() {
        val detailMovieEntities = viewModel.getDetailMovie()
        assertNotNull(detailMovieEntities)
        assertEquals(10, detailMovieEntities.size.toLong())
    }
}