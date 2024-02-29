package com.redbus.postalcodeapp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GeonamesInterface{

    @GET("postalCodeSearchJSON?username=shree")
    suspend fun getPlaces(@Query("postalcode") pincode: String): PlaceResponse

    // getPlaces("560011")
    // url - http://api.geonames.org/postalCodeSearchJSON?username=shree&postalcode=560011

    companion object{
        private val BASE_URL = "http://api.geonames.org/"

        private var instance: GeonamesInterface? = null

        fun getInstance(): GeonamesInterface {
            return instance ?: createInstance().also {
                instance = it
            }
        }

        private fun createInstance(): GeonamesInterface{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(GeonamesInterface::class.java)
        }
    }
}