package com.example.tmbdclient.data.repository.artist.datasource


import com.example.tmbdclient.data.model.artist.Artist


interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artist:List<Artist>)
    suspend fun clearAll()
}