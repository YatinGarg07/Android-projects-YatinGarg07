package com.example.tmbdclient.data.repository.artist.datasourceimpl


import com.example.tmbdclient.data.model.artist.Artist

import com.example.tmbdclient.data.repository.artist.datasource.ArtistCacheDataSource


class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private  var artistList = ArrayList<Artist>()

    override suspend fun saveArtistsToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }
}