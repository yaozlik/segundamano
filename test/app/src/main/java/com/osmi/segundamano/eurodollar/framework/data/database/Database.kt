package com.osmi.segundamano.eurodollar.framework.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.osmi.segundamano.eurodollar.framework.data.dao.RatesDao
import com.osmi.segundamano.eurodollar.framework.data.entity.RatesEntity

@Database(entities = [(RatesEntity::class)], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun ratesDao(): RatesDao
}