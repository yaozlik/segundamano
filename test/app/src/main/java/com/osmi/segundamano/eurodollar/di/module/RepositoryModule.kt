package com.osmi.segundamano.eurodollar.di.module

import com.osmi.segundamano.converter.data.datasource.RatesDataSource
import com.osmi.segundamano.converter.data.repository.RatesRepository
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(dataSource: RatesDataSource): RatesRepository {
        return RatesRepository(dataSource)
    }

}