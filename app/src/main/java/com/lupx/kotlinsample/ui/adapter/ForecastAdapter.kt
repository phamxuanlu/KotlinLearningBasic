package com.lupx.kotlinsample.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.lupx.kotlinsample.domain.model.ForecastList

class ForecastAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size;

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        with(weekForecast.dailyForecast[pos]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}