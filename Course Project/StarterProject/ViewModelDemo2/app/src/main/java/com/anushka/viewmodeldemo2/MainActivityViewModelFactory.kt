package com.anushka.viewmodeldemo2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalStateException

class MainActivityViewModelFactory(private val startingTotal : Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java))
            return MainActivityViewModel(startingTotal) as T

        else throw IllegalStateException("Unknown View Model Class")

    }
}