package com.example.myapplication.details.data.detaisdatasource

import com.example.myapplication.details.data.model.DetailsCharacters

interface DetailsDataSource {
    suspend fun getDetailsCharacters(id: Int): DetailsCharacters
}