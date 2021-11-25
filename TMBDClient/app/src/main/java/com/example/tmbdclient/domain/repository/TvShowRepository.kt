package com.example.tmbdclient.domain.repository

import com.example.tmbdclient.data.model.movie.Movie
import com.example.tmbdclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?

}