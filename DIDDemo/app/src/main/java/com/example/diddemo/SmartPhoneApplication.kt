package com.example.diddemo

import android.app.Application

class SmartPhoneApplication : Application() {
    lateinit var  smartPhoneComponent: SmartPhoneComponent
    override fun onCreate() {
        super.onCreate()
        smartPhoneComponent = initDagger()

    }

    fun initDagger() : SmartPhoneComponent =
        DaggerSmartPhoneComponent.builder()
        .memoryCardClassModule(MemoryCardClassModule(4000))
            .build()

}