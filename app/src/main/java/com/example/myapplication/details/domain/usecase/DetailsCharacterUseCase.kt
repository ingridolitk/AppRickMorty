package com.example.myapplication.details.domain.usecase

import com.example.myapplication.details.data.model.DetailsCharacters
import com.example.myapplication.details.domain.repository.DetailsRepository

class DetailsCharacterUseCase (val repository: DetailsRepository) {
    suspend operator fun invoke(id: Int): DetailsCharacters {
        return repository.detailsRepository(id)
    }
}