package com.example.defilmsapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.defilmsapp.R
import com.example.defilmsapp.databinding.HomeActivityBinding
import com.example.defilmsapp.ui.settings.SettingsActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var homeActivityBinding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityBinding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(homeActivityBinding.root)

        supportActionBar?.setTitle(getString(R.string.app_name))

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        homeActivityBinding.viewPager.adapter = sectionsPagerAdapter
        homeActivityBinding.tabs.setupWithViewPager(homeActivityBinding.viewPager)

        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when (itemId) {
            R.id.settings -> {
                val mIntent = Intent(this, SettingsActivity::class.java)
                startActivity(mIntent)
            }
        }
    }
}