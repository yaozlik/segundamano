package com.osmi.segundamano.converter.data.response

data class RatesResponse(
    val success: Boolean,
    val timestamp: Int,
    val historical: Boolean,
    val base: String,
    val date: String,
    val rates: RateResponse
)

data class RateResponse(val USD : Double)


// {"success":true,"timestamp":1576886399,"historical":true,"base":"EUR","date":"2019-12-20","rates":{"USD":1.107806}}