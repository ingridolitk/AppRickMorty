package com.example.myapplication.home.data.api

import com.example.myapplication.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService {

    fun createRetrofit(): CartoonApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CartoonApi::class.java)
    }
}
