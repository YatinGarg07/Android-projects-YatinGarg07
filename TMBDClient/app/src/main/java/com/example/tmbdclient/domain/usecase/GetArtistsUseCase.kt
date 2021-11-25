package com.example.tmbdclient.domain.usecase

import com.example.tmbdclient.data.model.artist.Artist
import com.example.tmbdclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>? =artistRepository.getArtists()
}