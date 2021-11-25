package com.example.tmbdclient.data.repository.tvshow.datasource


import com.example.tmbdclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun saveTvShowstoCache(tvShow:List<TvShow>)
    suspend fun getTvShowsFromCache():List<TvShow>
}