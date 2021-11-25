package com.example.tmbdclient.presentation.di.core

import com.example.tmbdclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmbdclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmbdclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmbdclient.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule  {

    @Provides
    @Singleton
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }



}