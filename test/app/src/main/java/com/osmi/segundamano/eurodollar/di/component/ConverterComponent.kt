package com.osmi.segundamano.eurodollar.di.component

import com.osmi.segundamano.converter.data.repository.RatesRepository
import com.osmi.segundamano.eurodollar.di.module.DataSourceModule
import com.osmi.segundamano.eurodollar.di.module.RepositoryModule
import com.osmi.segundamano.eurodollar.presentation.view.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(RepositoryModule::class, DataSourceModule::class)
)
interface ConverterComponent {

    fun provideRepository(): RatesRepository

    fun inject(activity: MainActivity)
}