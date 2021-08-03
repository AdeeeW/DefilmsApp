package com.example.defilmsapp.ui.detailMovies

import androidx.lifecycle.ViewModel
import com.example.defilmsapp.data.DetailMovieEntity
import com.example.defilmsapp.data.MoviesEntity
import com.example.defilmsapp.utils.Data

class DetailMoviesViewModel: ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MoviesEntity {
        lateinit var detailMovie: MoviesEntity
        val detailEntities = Data.generateDataMovies()
        for (detailEntity in detailEntities) {
            if (detailEntity.moviesId == movieId) {
                detailMovie = detailEntity
            }
        }
        return detailMovie
    }

    fun getDetailMovie(): List<DetailMovieEntity> = Data.generateDetailMovies(movieId)
}