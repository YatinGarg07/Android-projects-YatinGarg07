package com.example.tmbdclient.domain.usecase

import com.example.tmbdclient.data.model.tvshow.TvShow
import com.example.tmbdclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}