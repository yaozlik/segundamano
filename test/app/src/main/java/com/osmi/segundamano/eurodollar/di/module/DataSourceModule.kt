package com.osmi.segundamano.eurodollar.di.module

import com.osmi.segundamano.converter.data.datasource.RatesDataSource
import com.osmi.segundamano.eurodollar.framework.data.datasource.RoomRatesDataSource
import dagger.Module

import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideDataSource(): RatesDataSource {
        return RoomRatesDataSource()
    }

}