package com.lupx.kotlinsample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lupx.kotlinsample.R
import com.lupx.kotlinsample.domain.model.Forecast
import com.lupx.kotlinsample.domain.model.ForecastList
import com.lupx.kotlinsample.ui.utils.ctx
import kotlinx.android.synthetic.main.item_forecast.view.date
import kotlinx.android.synthetic.main.item_forecast.view.description
import kotlinx.android.synthetic.main.item_forecast.view.icon
import kotlinx.android.synthetic.main.item_forecast.view.maxTemperature
import kotlinx.android.synthetic.main.item_forecast.view.minTemperature

class ForecastAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size;

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bindForecast(weekForecast[pos])
    }

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Glide.with(itemView.icon).load(iconUrl).into(itemView.icon)
                itemView.date.text = date;
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}