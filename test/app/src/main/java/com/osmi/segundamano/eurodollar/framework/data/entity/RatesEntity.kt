package com.osmi.segundamano.eurodollar.framework.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rates_entity")
data class RatesEntity (
    @PrimaryKey @ColumnInfo(name="usd") val USD : Double,
    @ColumnInfo(name="date") val date: String
)