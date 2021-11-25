package com.example.tmbdclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmbdclient.domain.usecase.GetMoviesUseCase
import com.example.tmbdclient.domain.usecase.UpdateMoviesUseCases

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCases: UpdateMoviesUseCases
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCases.execute()
        emit(movieList)
    }
    }
