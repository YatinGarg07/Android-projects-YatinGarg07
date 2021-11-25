package com.example.tmbdclient.domain.repository

import com.example.tmbdclient.data.model.artist.Artist
import com.example.tmbdclient.data.model.movie.Movie

interface ArtistRepository {

    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}