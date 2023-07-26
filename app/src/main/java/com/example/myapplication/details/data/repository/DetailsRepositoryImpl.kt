package com.example.myapplication.details.data.repository

import com.example.myapplication.details.data.detaisdatasource.DetailsDataSource
import com.example.myapplication.details.data.model.DetailsCharacters
import com.example.myapplication.details.domain.repository.DetailsRepository

class DetailsRepositoryImpl(private val detailsDataSource: DetailsDataSource) : DetailsRepository {
    override suspend fun detailsRepository(id: Int): DetailsCharacters {
        return detailsDataSource.getDetailsCharacters(id)
    }
}