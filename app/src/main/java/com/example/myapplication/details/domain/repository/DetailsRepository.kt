package com.example.myapplication.details.domain.repository

import com.example.myapplication.details.data.model.DetailsCharacters

interface DetailsRepository {
    suspend fun detailsRepository(id: Int): DetailsCharacters
}