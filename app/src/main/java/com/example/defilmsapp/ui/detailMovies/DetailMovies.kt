package com.example.defilmsapp.ui.detailMovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.defilmsapp.R
import com.example.defilmsapp.data.MoviesEntity
import com.example.defilmsapp.databinding.ActivityDetailMoviesBinding

class DetailMovies : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIES_ID = "extra_movies_id"
    }

    private lateinit var activityDetailMoviesBinding: ActivityDetailMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMoviesBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(activityDetailMoviesBinding.root)

        supportActionBar?.setTitle(getString(R.string.detail_film))

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMoviesViewModel::class.java]
        val adapter = DetailMoviesAdapter()
        val extras = intent.extras
        if (extras != null) {
            val moviesId = extras.getString(EXTRA_MOVIES_ID)
            if (moviesId != null) {
                viewModel.setSelectedMovie(moviesId)
                val data = viewModel.getDetailMovie()
                adapter.setDetailMovies(data)
                populateMovies(viewModel.getMovie())
            }
        }

    }

    private fun populateMovies(movie: MoviesEntity) {
        activityDetailMoviesBinding.tvDetailJudul.text = movie.judulMovie
        activityDetailMoviesBinding.tvDetailStatus.text = movie.status
        activityDetailMoviesBinding.tvDetailBahasa.text = movie.bahasa
        activityDetailMoviesBinding.tvDetailGenre.text = movie.genre
        activityDetailMoviesBinding.tvDetailDurasi.text = movie.durasi
        activityDetailMoviesBinding.tvDetailDeskripsi.text = movie.description
        Glide.with(this)
            .load(movie.imagePosterMovies)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(activityDetailMoviesBinding.ivPoster)
        Glide.with(this)
            .load(movie.imagePosterMovies)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .centerCrop()
            .into(activityDetailMoviesBinding.imgBg)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.share, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.share -> {
                val shareIntent = Intent().apply {
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_TEXT,"Anda Dapat Mencari Detail Movie Disini\n" +
                            getString(R.string.link_film))
                    this.type="text/plain"
                }
                startActivity(Intent.createChooser(shareIntent,getString(R.string.text_bagi)))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
