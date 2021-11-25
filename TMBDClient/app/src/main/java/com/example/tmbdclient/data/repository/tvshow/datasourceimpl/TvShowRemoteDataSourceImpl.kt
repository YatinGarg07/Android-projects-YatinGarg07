package com.example.tmbdclient.data.repository.tvshow.datasourceimpl

import com.example.tmbdclient.data.api.TMDBService
import com.example.tmbdclient.data.model.movie.MovieList
import com.example.tmbdclient.data.model.tvshow.TvShowList
import com.example.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> =tmdbService.getPopularTvShows(apiKey)

}