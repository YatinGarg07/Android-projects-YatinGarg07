package com.example.tmbdclient.data.repository.movie.datasourceimpl

import com.example.tmbdclient.data.model.movie.Movie
import com.example.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private  var movieList = ArrayList<Movie>()
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }
}