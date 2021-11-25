package com.example.tmbdclient.presentation.di.core

import com.example.tmbdclient.data.api.TMDBService
import com.example.tmbdclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmbdclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmbdclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmbdclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Provides
    @Singleton
    fun provideMovieDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }
    @Provides
    @Singleton
    fun provideTvShowDataSource(tmdbService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService,apiKey)
    }
    @Provides
    @Singleton
    fun provideArtistDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }

}