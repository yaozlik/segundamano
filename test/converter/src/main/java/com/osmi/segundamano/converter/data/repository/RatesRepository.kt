package com.osmi.segundamano.converter.data.repository

import com.google.gson.GsonBuilder
import com.osmi.segundamano.converter.data.datasource.RatesDataSource
import com.osmi.segundamano.converter.data.service.ConvertService
import com.osmi.segundamano.converter.domain.Rates
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class RatesRepository @Inject constructor(private val dataSource: RatesDataSource) {

    companion object {
        fun getService(): ConvertService {
             val okHttpClient =  OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()


           return Retrofit.Builder()
                .baseUrl("http://data.fixer.io")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(ConvertService::class.java)
        }
    }

    suspend fun getRates(date: String): Rates? {
        // first try to get rates by network
        try {
            val service = getService()

            val response = service.getRates(date = date, base = "EUR", symbols = "USD")

            val rates = Rates(response.rates.USD, response.date)
            dataSource.saveRates(rates)
            return rates
        } catch (e: Exception) {
            return dataSource.getRatesByDate(date)
        }

    }

}