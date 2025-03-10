package com.easy.GeoWarden.repository.api

import android.content.ContentValues.TAG
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import timber.log.Timber.Forest.tag
import java.util.concurrent.CountDownLatch

class APICalls {
    fun locationDetails(){
        val retrofitClient = NetworkUtils.getRetrofitInstace("http://api.openweathermap.org/")
        val endpoint = retrofitClient.create(GeocoderAPIService::class.java)
        var data = mutableListOf<String>()
        val latch = CountDownLatch(1)


        endpoint.locationData().enqueue(object : retrofit2.Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                response.body()?.keySet()?.iterator()?.forEach { data.add(it) }

                Timber.plant(Timber.DebugTree())
                tag(TAG).w(" Hit 1 ${data.count()}")
                latch.countDown()

            }

            override fun onFailure(p0: Call<JsonObject>, p1: Throwable) {
                Timber.plant(Timber.DebugTree())
                tag(TAG).w(" erro ")
                latch.countDown()
            }
        })
        latch.await()
        println("$data")
    }
}