package com.osmi.segundamano.converter.data.service

import com.osmi.segundamano.converter.data.response.RatesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ConvertService {

    @GET("api/{date}")
    suspend fun getRates(@Path("date") date: String,
                         @Query("access_key") accessKey: String = "db9822ef84b355af48cccf9ab2eceffe",
                         @Query("base") base: String,
                         @Query("symbols") symbols: String): RatesResponse
}

// http://data.fixer.io/api/2019-12-20?access_key=db9822ef84b355af48cccf9ab2eceffe&base=EUR&symbols=USD
