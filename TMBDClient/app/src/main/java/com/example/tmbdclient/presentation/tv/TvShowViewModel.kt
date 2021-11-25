package com.example.tmbdclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmbdclient.domain.usecase.GetTvShowsUseCase
import com.example.tmbdclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase : UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowsList = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows() = liveData {
        val tvShowsList = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }

}