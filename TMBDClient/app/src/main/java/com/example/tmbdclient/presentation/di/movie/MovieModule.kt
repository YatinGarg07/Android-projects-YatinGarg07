package com.example.tmbdclient.presentation.di.movie

import com.example.tmbdclient.domain.usecase.GetMoviesUseCase
import com.example.tmbdclient.domain.usecase.UpdateMoviesUseCases
import com.example.tmbdclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase : UpdateMoviesUseCases
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase,updateMovieUseCase)
    }
}