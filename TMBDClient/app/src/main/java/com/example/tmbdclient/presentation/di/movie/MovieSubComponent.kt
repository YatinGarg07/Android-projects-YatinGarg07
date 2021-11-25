package com.example.tmbdclient.presentation.di.movie

import com.example.tmbdclient.presentation.artist.ArtistActivity
import com.example.tmbdclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}