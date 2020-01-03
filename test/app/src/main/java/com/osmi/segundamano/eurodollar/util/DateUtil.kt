package com.osmi.segundamano.eurodollar.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

fun Date.getDatesBeforeNow(): List<String> {

    var formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy")
    var date = LocalDate.parse(Date().toString(), formatter)
    return arrayListOf()
}