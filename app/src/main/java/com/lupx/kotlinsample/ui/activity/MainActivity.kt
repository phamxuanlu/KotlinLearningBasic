package com.lupx.kotlinsample.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.lupx.kotlinsample.R
import com.lupx.kotlinsample.data.Artist
import com.lupx.kotlinsample.domain.commands.RequestForecastCommand
import com.lupx.kotlinsample.ui.adapter.ForecastAdapter
import kotlinx.android.synthetic.main.activity_main.rcvForecast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcvForecast.layoutManager = LinearLayoutManager(this)
        requestData()
    }

    fun requestData() {
        doAsync {
            val result = RequestForecastCommand("hanoi").execute()
            uiThread {
                rcvForecast.adapter = ForecastAdapter(result){ forecast -> toast(forecast.date) }
            }
        }
    }

    fun Artist.drawing(obj: String) {
        Toast.makeText(this@MainActivity, "I'm ${name} I'm drawing " + obj, Toast.LENGTH_SHORT).show()
    }
}
