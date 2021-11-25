package com.example.tmbdclient.data.repository.movie.datasource

import com.example.tmbdclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun saveMoviesToCache(movies:List<Movie>)
    suspend fun getMoviesFromCache():List<Movie>
}