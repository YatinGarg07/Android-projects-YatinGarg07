package com.example.tmbdclient.domain.usecase

import com.example.tmbdclient.data.model.movie.Movie
import com.example.tmbdclient.domain.repository.MovieRepository

class UpdateMoviesUseCases(private val movieRepository: MovieRepository)  {

suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}