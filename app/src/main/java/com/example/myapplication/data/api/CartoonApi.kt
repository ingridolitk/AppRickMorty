package com.example.myapplication.data.api

import com.example.myapplication.data.model.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET

interface CartoonApi {

    @GET("character")
    suspend fun characterRickyandMory(): CharactersResponse
}