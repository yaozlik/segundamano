package com.osmi.segundamano.eurodollar.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osmi.segundamano.converter.data.repository.RatesRepository
import com.osmi.segundamano.converter.domain.Rates
import com.osmi.segundamano.converter.interactor.GetRates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RatesViewModel: ViewModel() {


    private lateinit var getRatesUseCase: GetRates


    var ratesLV: MutableLiveData<Rates>? = MutableLiveData()

    fun setRepository(repository: RatesRepository) {
        getRatesUseCase = GetRates(repository)
    }

    fun getRates() {
        CoroutineScope(Dispatchers.IO).launch {
            invokeGetRates()
        }
    }

    private suspend fun invokeGetRates() = withContext(Dispatchers.IO){
        val array = getDateArray().reversed()
        for (e in array) {
            ratesLV?.postValue(getRatesUseCase.invoke(e))
        }
    }

    private fun getDateArray(): List<String> {
        val array = arrayListOf<String>()
        for (index in 0..10) {
            array.add(
                LocalDate.now().minusDays(index.toLong()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            )
        }

        return array
    }
}