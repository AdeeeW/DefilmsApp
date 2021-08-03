package com.example.defilmsapp.ui.detailMovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.defilmsapp.R
import com.example.defilmsapp.data.DetailMovieEntity
import com.example.defilmsapp.databinding.ActivityDetailMoviesBinding
import java.util.ArrayList

class DetailMoviesAdapter :RecyclerView.Adapter<DetailMoviesAdapter.DetailMovieViewHolder>() {
    private var listDetailMovies = ArrayList<DetailMovieEntity>()

    fun setDetailMovies(detailMovies: List<DetailMovieEntity>?) {
        if (detailMovies == null) return
        this.listDetailMovies.clear()
        this.listDetailMovies.addAll(detailMovies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailMovieViewHolder {
        val detailMoviesBinding = ActivityDetailMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailMovieViewHolder(detailMoviesBinding)
    }

    override fun onBindViewHolder(holder: DetailMovieViewHolder, position: Int) {
        val detailMovies = listDetailMovies[position]
        holder.bind(detailMovies)
    }

    override fun getItemCount(): Int = listDetailMovies.size


    class DetailMovieViewHolder(private val binding: ActivityDetailMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(detailMovies: DetailMovieEntity) {
            with(binding) {
                tvDetailJudul.text = detailMovies.judulMovie
                tvDetailStatus.text = detailMovies.status
                tvDetailBahasa.text = detailMovies.bahasa
                tvDetailGenre.text = detailMovies.genre
                tvDetailDurasi.text = detailMovies.durasi
                tvDetailDeskripsi.text = detailMovies.description

                Glide.with(itemView.context)
                    .load(detailMovies.imagePosterMovies)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(ivPoster)
                Glide.with(itemView.context)
                    .load(detailMovies.imagePosterMovies)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .thumbnail()
                    .into(imgBg)
            }
        }
    }
}
