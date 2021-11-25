package com.example.tmbdclient.domain.repository

import com.example.tmbdclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}