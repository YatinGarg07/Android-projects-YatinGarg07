package com.example.tmbdclient.data.repository.tvshow.datasourceimpl


import com.example.tmbdclient.data.model.tvshow.TvShow
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private  var tvShowList = ArrayList<TvShow>()

    override suspend fun saveTvShowstoCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }
}