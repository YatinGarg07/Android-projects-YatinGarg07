package com.example.tmbdclient.presentation.di.artist

import com.example.tmbdclient.domain.usecase.GetArtistsUseCase
import com.example.tmbdclient.domain.usecase.UpdateArtistsUseCase
import com.example.tmbdclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}