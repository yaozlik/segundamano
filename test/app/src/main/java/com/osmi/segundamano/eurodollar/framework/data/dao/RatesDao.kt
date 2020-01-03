package com.osmi.segundamano.eurodollar.framework.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.osmi.segundamano.eurodollar.framework.data.entity.RatesEntity

@Dao
interface RatesDao {

    @Query("SELECT * FROM rates_entity")
    fun getAll(): List<RatesEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(rate: RatesEntity)

    @Query("SELECT * FROM rates_entity where date = :dateParam")
    fun getRatesByDate(dateParam: String): RatesEntity?
}