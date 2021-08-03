package com.example.defilmsapp.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.defilmsapp.R
import com.example.defilmsapp.data.MoviesEntity
import com.example.defilmsapp.databinding.ListItemMoviesBinding
import com.example.defilmsapp.ui.detailMovies.DetailMovies
import java.util.ArrayList

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MoviesEntity>()

    fun setMovies(movies: List<MoviesEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val listItemMoviesBinding = ListItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(listItemMoviesBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    class MovieViewHolder(private val binding: ListItemMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                tvItemJudul.text = movies.judulMovie
                tvItemDescription.text = movies.description
                tvItemTglLiris.text = movies.tanggalRilis
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovies::class.java)
                    intent.putExtra(DetailMovies.EXTRA_MOVIES_ID, movies.moviesId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movies.imagePosterMovies)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }
}
