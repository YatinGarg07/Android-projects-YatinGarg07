package com.example.tmbdclient.data.repository.tvshow

import android.util.Log
import com.example.tmbdclient.data.model.tvshow.TvShow
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmbdclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmbdclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {


    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsfromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOftvShow = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOftvShow)
        tvShowCacheDataSource.saveTvShowstoCache(newListOftvShow)

        return newListOftvShow
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(tvShowList.size>0) {
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsfromCache():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()

        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if(tvShowList.size>0) {
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowstoCache(tvShowList)
        }
        return tvShowList
    }


}