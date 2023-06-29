package com.example.myapplication.details.data.api

import com.example.myapplication.details.data.api.DetailsApi.PatchConstants.DETAILS
import com.example.myapplication.details.data.model.DetailsCharacters
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET(DETAILS)
    suspend fun getDetailsMovies(
        @Path("id") id: Int
    ): DetailsCharacters

    object PatchConstants {
        const val DETAILS = "{id}"
    }
}