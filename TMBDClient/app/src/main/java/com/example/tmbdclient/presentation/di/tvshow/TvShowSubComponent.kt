package com.example.tmbdclient.presentation.di.tvshow

import com.example.tmbdclient.presentation.artist.ArtistActivity
import com.example.tmbdclient.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}