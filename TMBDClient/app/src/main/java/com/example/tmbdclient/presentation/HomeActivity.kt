package com.example.tmbdclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmbdclient.R
import com.example.tmbdclient.data.model.artist.Artist
import com.example.tmbdclient.data.model.tvshow.TvShow
import com.example.tmbdclient.databinding.ActivityHomeBinding
import com.example.tmbdclient.presentation.artist.ArtistActivity
import com.example.tmbdclient.presentation.movie.MovieActivity
import com.example.tmbdclient.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.apply {
            movieButton.setOnClickListener {
                val intent = Intent(applicationContext,MovieActivity::class.java)
                startActivity(intent)
            }

            tvButton.setOnClickListener{
                val intent = Intent(applicationContext, TvShowActivity::class.java)
                startActivity(intent)
            }

            artistsButton.setOnClickListener {
                val intent = Intent(applicationContext, ArtistActivity::class.java)
                startActivity(intent)
            }
        }

    }
}