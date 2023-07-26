package com.example.myapplication.details.data.detaisdatasource

import com.example.myapplication.details.data.api.DetailsApi
import com.example.myapplication.details.data.model.DetailsCharacters

class DetailsDataSourceImpl(private val api: DetailsApi) : DetailsDataSource {
    override suspend fun getDetailsCharacters(id: Int): DetailsCharacters {
        return api.getDetailsMovies(id)
    }
}