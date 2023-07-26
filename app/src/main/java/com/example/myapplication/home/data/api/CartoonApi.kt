package com.example.myapplication.home.data.api

import com.example.myapplication.home.data.api.CartoonApi.PatchConstants.CHARACTER
import com.example.myapplication.home.data.model.CharactersResponse
import retrofit2.http.GET

interface CartoonApi {

    @GET(CHARACTER)
    suspend fun characterRickyandMory(): CharactersResponse
    object PatchConstants {
        const val CHARACTER = "character"
    }
}