package com.example.tmbdclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmbdclient.domain.usecase.GetMoviesUseCase
import com.example.tmbdclient.domain.usecase.UpdateMoviesUseCases

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCases: UpdateMoviesUseCases
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return MovieViewModel(getMoviesUseCase,updateMoviesUseCases) as T
    }
}