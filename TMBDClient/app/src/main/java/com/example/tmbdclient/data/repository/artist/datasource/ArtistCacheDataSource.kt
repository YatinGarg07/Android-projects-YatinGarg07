package com.example.tmbdclient.data.repository.artist.datasource


import com.example.tmbdclient.data.model.artist.Artist


interface ArtistCacheDataSource {
    suspend fun saveArtistsToCache(artist:List<Artist>)
    suspend fun getArtistsFromCache():List<Artist>
}