package com.osmi.segundamano.eurodollar.presentation.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.osmi.segundamano.converter.domain.Rates

import com.osmi.segundamano.eurodollar.R
import com.osmi.segundamano.eurodollar.presentation.viewmodel.RatesViewModel
import com.github.mikephil.charting.data.LineData
import android.graphics.DashPathEffect
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.osmi.segundamano.converter.data.repository.RatesRepository
import com.osmi.segundamano.eurodollar.di.component.DaggerConverterComponent
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.rates_chart
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: RatesViewModel
    private var listRates = arrayListOf<Rates>()

    @Inject lateinit var repository: RatesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerConverterComponent.create().inject(this)
        viewModel =  ViewModelProviders.of(this).get(RatesViewModel::class.java)
        viewModel.setRepository(repository)


        subscribeLiveData()

        button.setOnClickListener {
            configureChart()
            listRates.clear()
            viewModel.getRates()
        }
    }

    private fun configureChart() {
        rates_chart.setBackgroundColor(Color.WHITE)
        rates_chart.setTouchEnabled(true)

        val set1: LineDataSet

        val values = ArrayList<Entry>()

        set1 = LineDataSet(values, "Rate Euro Dolar")
        set1.setDrawIcons(false)
        set1.enableDashedLine(10f, 5f, 0f)
        set1.enableDashedHighlightLine(10f, 5f, 0f)
        set1.color = Color.DKGRAY
        set1.setCircleColor(Color.DKGRAY)
        set1.lineWidth = 1f
        set1.circleRadius = 3f
        set1.setDrawCircleHole(false)
        set1.valueTextSize = 9f
        set1.setDrawFilled(true)
        set1.formLineWidth = 1f
        set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
        set1.formSize = 15f

        val dataSets = ArrayList<LineDataSet>()
        dataSets.add(set1)
        val data = LineData(dataSets as List<ILineDataSet>?)
        rates_chart.data = data
    }

    private fun updateChart(index: Float, value: Rates) {

        rates_chart.data.addEntry(Entry(index,value.USD.toFloat()), 0)

        rates_chart.data.notifyDataChanged()
        rates_chart.notifyDataSetChanged()
        rates_chart.invalidate()
    }

    private fun subscribeLiveData() {

        val observer = Observer<Rates> { rates ->
            if (rates != null) {
                listRates.add(rates)
                updateChart(listRates.size.toFloat(), rates)
            }
        }
        viewModel.ratesLV?.observe(this, observer)
    }
}
