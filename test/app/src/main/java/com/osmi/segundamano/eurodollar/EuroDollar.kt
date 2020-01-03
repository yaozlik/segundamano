package com.osmi.segundamano.eurodollar

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.osmi.segundamano.eurodollar.di.component.ConverterComponent
import com.osmi.segundamano.eurodollar.di.component.DaggerConverterComponent
import com.osmi.segundamano.eurodollar.framework.data.database.Database

class EuroDollar: Application() {

    companion object {
        var database: Database? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, Database::class.java,
            "rates-db").build()
    }
}