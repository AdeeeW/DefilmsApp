package com.example.defilmsapp.ui.tvShow

import androidx.lifecycle.ViewModel
import com.example.defilmsapp.data.TvShowEntity
import com.example.defilmsapp.utils.Data

class TvShowViewModel: ViewModel() {
    fun getTvShow(): List<TvShowEntity> = Data.generateDataTvShow()
}