package com.example.tmbdclient.data.repository.movie.datasource

import com.example.tmbdclient.data.model.movie.Movie
import com.example.tmbdclient.data.model.movie.MovieList
import com.example.tmbdclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun  getMovies() : Response<MovieList>
}