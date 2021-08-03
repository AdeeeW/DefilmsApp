package com.example.defilmsapp.ui.movies

import androidx.lifecycle.ViewModel
import com.example.defilmsapp.data.MoviesEntity
import com.example.defilmsapp.utils.Data

class MoviesViewModel: ViewModel() {
    fun getMovies(): List<MoviesEntity> = Data.generateDataMovies()
}