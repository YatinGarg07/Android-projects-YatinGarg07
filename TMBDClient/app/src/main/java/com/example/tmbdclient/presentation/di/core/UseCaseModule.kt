package com.example.tmbdclient.presentation.di.core

import com.example.tmbdclient.domain.repository.ArtistRepository
import com.example.tmbdclient.domain.repository.MovieRepository
import com.example.tmbdclient.domain.repository.TvShowRepository
import com.example.tmbdclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUSeCase(movieRepository: MovieRepository) : UpdateMoviesUseCases{
        return UpdateMoviesUseCases(movieRepository)
    }

    @Provides
    fun provideGetTvShowsUseCase(tvShowRepository: TvShowRepository) : GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUSeCase(tvShowRepository: TvShowRepository) : UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }


    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository) : GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUSeCase(artistRepository: ArtistRepository) : UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }


}