package com.example.defilmsapp.ui.detailTvShow

import androidx.lifecycle.ViewModel
import com.example.defilmsapp.data.DetailTvShowEntity
import com.example.defilmsapp.data.TvShowEntity
import com.example.defilmsapp.utils.Data

class DetailTvShowViewModel: ViewModel() {
    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity {
        lateinit var detailTvShow: TvShowEntity
        val detailEntities = Data.generateDataTvShow()
        for (detailEntity in detailEntities) {
            if (detailEntity.tvShowId == tvShowId) {
                detailTvShow = detailEntity
            }
        }
        return detailTvShow
    }

    fun getDetailTvShow(): List<DetailTvShowEntity> = Data.generateDetailTvShow(tvShowId)
}