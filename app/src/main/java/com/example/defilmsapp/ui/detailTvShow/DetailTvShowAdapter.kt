package com.example.defilmsapp.ui.detailTvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.defilmsapp.R
import com.example.defilmsapp.data.DetailTvShowEntity
import com.example.defilmsapp.databinding.ActivityDetailTvShowBinding
import java.util.ArrayList

class DetailTvShowAdapter : RecyclerView.Adapter<DetailTvShowAdapter.DetailTvShowViewHolder>() {
    private var listDetailTvShow = ArrayList<DetailTvShowEntity>()

    fun setDetailTvShow(detailTvShow: List<DetailTvShowEntity>?) {
        if (detailTvShow == null) return
        this.listDetailTvShow.clear()
        this.listDetailTvShow.addAll(detailTvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailTvShowViewHolder {
        val detailTvShowBinding= ActivityDetailTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailTvShowViewHolder(detailTvShowBinding)
    }

    override fun onBindViewHolder(holder: DetailTvShowViewHolder, position: Int) {
        val detailTvShow = listDetailTvShow[position]
        holder.bind(detailTvShow)
    }

    override fun getItemCount(): Int = listDetailTvShow.size


    class DetailTvShowViewHolder(private val binding: ActivityDetailTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detailTvShow: DetailTvShowEntity) {
            with(binding) {
                tvDetailJudul.text = detailTvShow.judulTvShow
                tvDetailStatus.text = detailTvShow.status
                tvDetailBahasa.text = detailTvShow.bahasa
                tvDetailGenre.text = detailTvShow.genre
                tvDetailDeskripsi.text = detailTvShow.description
                tvDetailStatus.text = detailTvShow.status
                tvDetailJenis.text = detailTvShow.jenis

                Glide.with(itemView.context)
                    .load(detailTvShow.imagePosterMoviesTv)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(ivPoster)
                Glide.with(itemView.context)
                    .load(detailTvShow.imagePosterMoviesTv)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .thumbnail()
                    .into(imgBg)
            }
        }
    }
}