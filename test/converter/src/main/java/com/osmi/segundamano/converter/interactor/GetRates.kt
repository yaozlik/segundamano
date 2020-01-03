package com.osmi.segundamano.converter.interactor

import com.osmi.segundamano.converter.data.repository.RatesRepository

class GetRates(private val ratesRepository: RatesRepository) {

    suspend fun invoke(date: String) = ratesRepository.getRates(date)
}