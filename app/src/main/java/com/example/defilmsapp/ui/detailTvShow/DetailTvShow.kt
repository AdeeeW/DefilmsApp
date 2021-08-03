package com.example.defilmsapp.ui.detailTvShow

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
import com.example.defilmsapp.data.TvShowEntity
import com.example.defilmsapp.databinding.ActivityDetailTvShowBinding

class DetailTvShow : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW_ID = "extra_tvshow_id"
    }
    private lateinit var activityDetailTvShowBinding: ActivityDetailTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(activityDetailTvShowBinding.root)

        supportActionBar?.setTitle(getString(R.string.detail_tv))

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailTvShowViewModel::class.java]

        val adapter = DetailTvShowAdapter()
        val extras = intent.extras
        if (extras != null) {
            val moviesId = extras.getString(DetailTvShow.EXTRA_TVSHOW_ID)
            if (moviesId != null) {
                viewModel.setSelectedTvShow(moviesId)
                val data = viewModel.getDetailTvShow()
                adapter.setDetailTvShow(data)
                populateMovies(viewModel.getTvShow())
            }
        }
    }

    private fun populateMovies(tvShow: TvShowEntity) {
        activityDetailTvShowBinding.tvDetailJudul.text = tvShow.judulTvShow
        activityDetailTvShowBinding.tvDetailStatus.text = tvShow.status
        activityDetailTvShowBinding.tvDetailBahasa.text = tvShow.bahasa
        activityDetailTvShowBinding.tvDetailGenre.text = tvShow.genre
        activityDetailTvShowBinding.tvDetailJenis.text = tvShow.jenis
        activityDetailTvShowBinding.tvDetailEpisode.text = tvShow.jumlahEpisod
        activityDetailTvShowBinding.tvDetailDeskripsi.text = tvShow.description
        Glide.with(this)
            .load(tvShow.imagePosterMoviesTv)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(activityDetailTvShowBinding.ivPoster)
        Glide.with(this)
            .load(tvShow.imagePosterMoviesTv)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .centerCrop()
            .into(activityDetailTvShowBinding.imgBg)
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
                    this.putExtra(Intent.EXTRA_TEXT,"Anda Dapat Mencari Detail TV Show Disini\n" +
                            getString(R.string.link_tv))
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