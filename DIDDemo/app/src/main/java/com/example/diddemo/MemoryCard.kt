package com.example.diddemo

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemoryCard {
    init {
        Log.i("MYTAG","Memory Card Constructed")
    }

    fun getSpaceAvailablity(){
        Log.i("MYTAG","Memory space available")
    }
}