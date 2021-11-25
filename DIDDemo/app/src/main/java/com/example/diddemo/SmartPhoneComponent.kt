package com.example.diddemo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardClassModule::class,NCBatteryModule::class])
interface SmartPhoneComponent {

    fun inject(mainActivity: MainActivity)


}