package com.example.diddemo

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NCBatteryModule {

    @Binds
    abstract fun provideNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}