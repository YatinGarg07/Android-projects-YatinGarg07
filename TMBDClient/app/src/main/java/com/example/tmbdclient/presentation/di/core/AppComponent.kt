package com.example.tmbdclient.presentation.di.core

import com.example.tmbdclient.presentation.di.artist.ArtistSubComponent
import com.example.tmbdclient.presentation.di.movie.MovieSubComponent
import com.example.tmbdclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
NetModule::class,
CacheDataModule::class,
DatabaseModule::class,
LocalDataModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UseCaseModule::class
])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
}