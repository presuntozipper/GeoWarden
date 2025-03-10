package com.easy.GeoWarden.repository.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface GeocoderAPIService {

    @GET("http://api.openweathermap.org/geo/1.0/direct?q=São Paulo&limit=1&appid=c9eb2fcd4d3cacd6f08e55dcb45e3c59")
    fun locationData(): Call<JsonObject>
}

