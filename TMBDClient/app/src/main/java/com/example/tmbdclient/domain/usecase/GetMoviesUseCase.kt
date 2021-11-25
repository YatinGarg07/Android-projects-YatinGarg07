package com.example.tmbdclient.domain.usecase

import com.example.tmbdclient.data.model.movie.Movie
import com.example.tmbdclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()

}