package com.osmi.segundamano.eurodollar.framework.data.datasource

import com.osmi.segundamano.converter.data.datasource.RatesDataSource
import com.osmi.segundamano.converter.domain.Rates
import com.osmi.segundamano.eurodollar.EuroDollar
import com.osmi.segundamano.eurodollar.framework.data.entity.RatesEntity

class RoomRatesDataSource: RatesDataSource {
    override suspend fun getRatesByDate(date: String): Rates? {

        val r = EuroDollar.database?.ratesDao()?.getRatesByDate(date)
        var rates: Rates? = null

        if (r != null) {
            rates = Rates(r.USD, r.date)
        }
        return rates
    }

    override suspend fun getRates(): List<Rates>? {
        val arrayRates = arrayListOf<Rates>()
        EuroDollar.database?.ratesDao()?.getAll()?.forEach {
            arrayRates.add(Rates(it.USD, it.date))
        }

        return arrayRates
    }

    override suspend fun saveRates(rates: Rates) {
        val entity = RatesEntity(rates.USD, rates.date)
        EuroDollar.database?.ratesDao()?.save(entity)
    }
}