package com.example.tmbdclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmbdclient.domain.usecase.GetArtistsUseCase
import com.example.tmbdclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase : GetArtistsUseCase ,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtists()= liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }

}