package com.example.tmbdclient.data.repository.tvshow.datasource

import com.example.tmbdclient.data.model.movie.Movie
import com.example.tmbdclient.data.model.movie.MovieList
import com.example.tmbdclient.data.model.tvshow.TvShow
import com.example.tmbdclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun  getTvShows() : Response<TvShowList>
}