package com.example.tmbdclient.data.repository.movie

import android.util.Log
import com.example.tmbdclient.data.model.movie.Movie
import com.example.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmbdclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmbdclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
      return  getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOFMovie = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOFMovie)
        movieCacheDataSource.saveMoviesToCache(newListOFMovie)
        return newListOFMovie
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null){
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList : List<Movie>
        try {
                movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(movieList.size>0) {
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(movieList.size>0) {
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}