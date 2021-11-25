package com.example.tmbdclient.presentation.di.core

import com.example.tmbdclient.data.db.ArtistDao
import com.example.tmbdclient.data.db.MovieDao
import com.example.tmbdclient.data.db.TvShowDao
import com.example.tmbdclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmbdclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.tmbdclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmbdclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmbdclient.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Provides
    @Singleton
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao) : TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
    @Provides
    @Singleton
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }


}