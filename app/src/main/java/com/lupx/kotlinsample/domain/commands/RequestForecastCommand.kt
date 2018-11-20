package com.lupx.kotlinsample.domain.commands

import com.lupx.kotlinsample.data.ForecastRequest
import com.lupx.kotlinsample.domain.mappers.ForecastDataMapper
import com.lupx.kotlinsample.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}