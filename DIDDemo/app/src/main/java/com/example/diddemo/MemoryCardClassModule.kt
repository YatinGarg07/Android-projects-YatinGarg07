package com.example.diddemo

import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MemoryCardClassModule(val memorySize : Int) {

    @Provides
    fun providesMemoryCard() : MemoryCard{
        Log.i("MYTAG","Size of the memory is $memorySize")
        return  MemoryCard()
    }

}