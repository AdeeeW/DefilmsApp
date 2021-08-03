package com.example.defilmsapp.ui.detailTvShow

import com.example.defilmsapp.ui.detailMovies.DetailMoviesViewModel
import com.example.defilmsapp.utils.Data
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = Data.generateDataTvShow()[0]
    private val TvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setSelectedTvShow(TvShowId)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.imagePosterMoviesTv, tvShowEntity.imagePosterMoviesTv)
        assertEquals(dummyTvShow.bahasa, tvShowEntity.bahasa)
        assertEquals(dummyTvShow.description, tvShowEntity.description)
        assertEquals(dummyTvShow.judulTvShow, tvShowEntity.judulTvShow)
        assertEquals(dummyTvShow.jumlahEpisod, tvShowEntity.jumlahEpisod)
        assertEquals(dummyTvShow.status, tvShowEntity.status)
        assertEquals(dummyTvShow.jenis, tvShowEntity.jenis)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
    }

    @Test
    fun getDetailMovie() {
        val detailTvShowViewModel = viewModel.getDetailTvShow()
        assertNotNull(detailTvShowViewModel)
        assertEquals(10, detailTvShowViewModel.size.toLong())
    }
}