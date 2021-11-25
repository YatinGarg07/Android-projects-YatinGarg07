package com.example.tmbdclient.data.repository.artist.datasourceimpl

import com.example.tmbdclient.data.api.TMDBService
import com.example.tmbdclient.data.model.artist.ArtistList
import com.example.tmbdclient.data.repository.artist.datasource.ArtistRemoteDataSource

import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) : ArtistRemoteDataSource {


    override suspend fun getArtists(): Response<ArtistList> =tmdbService.getPopularArtists(apiKey)

}