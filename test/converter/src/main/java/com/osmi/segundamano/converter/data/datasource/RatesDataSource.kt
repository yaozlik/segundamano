package com.osmi.segundamano.converter.data.datasource

import com.osmi.segundamano.converter.domain.Rates

interface RatesDataSource {
    suspend fun getRates(): List<Rates>?

    suspend fun saveRates(rates: Rates)

    suspend fun getRatesByDate(date: String): Rates?

}