package com.example.defilmsapp.ui.tvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.defilmsapp.R
import com.example.defilmsapp.data.TvShowEntity
import com.example.defilmsapp.databinding.ListItemTvShowBinding
import com.example.defilmsapp.ui.detailTvShow.DetailTvShow
import java.util.ArrayList

class TvShowsAdapter: RecyclerView.Adapter<TvShowsAdapter.TvShowViewHolder>() {
    private var listTvShow = ArrayList<TvShowEntity>()

    fun setTvShow(tvShow: List<TvShowEntity>?) {
        if (tvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShow)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val listItemTvShowBinding = ListItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(listItemTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size

    class TvShowViewHolder(private val binding: ListItemTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvItemJudul.text = tvShow.judulTvShow
                tvItemDescription.text = tvShow.description
                tvItemTglRilis.text = tvShow.tanggalTayang
                tvItemEpisod.text = tvShow.jumlahEpisod
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShow::class.java)
                    intent.putExtra(DetailTvShow.EXTRA_TVSHOW_ID, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.imagePosterMoviesTv)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }
}