package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.model.Result
import com.example.myapplication.domain.repository.DetailsCharactersRepository

class DetailsCharacterUseCase(private val repository: DetailsCharactersRepository) {
    suspend operator fun invoke(): Result {
        return repository.getDetailsCharacters()
    }
}