package com.example.tmbdclient.data.repository.movie.datasource

import com.example.tmbdclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}