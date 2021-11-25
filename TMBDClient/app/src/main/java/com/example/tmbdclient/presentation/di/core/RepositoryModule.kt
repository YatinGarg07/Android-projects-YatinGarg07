package com.example.tmbdclient.presentation.di.core

import com.example.tmbdclient.data.repository.artist.ArtistRepositoryImpl
import com.example.tmbdclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmbdclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmbdclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmbdclient.data.repository.movie.MovieRepositoryImpl
import com.example.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmbdclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmbdclient.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmbdclient.domain.repository.ArtistRepository
import com.example.tmbdclient.domain.repository.MovieRepository
import com.example.tmbdclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
    movieLocalDataSource: MovieLocalDataSource,
    movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource ,
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ) : TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
       artistRemoteDataSource: ArtistRemoteDataSource,
       artistLocalDataSource: ArtistLocalDataSource,
       artistCacheDataSource: ArtistCacheDataSource

    ) : ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }

}