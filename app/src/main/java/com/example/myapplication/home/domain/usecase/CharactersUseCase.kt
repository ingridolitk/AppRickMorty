package com.example.myapplication.home.domain.usecase

import com.example.myapplication.domain.model.Characters
import com.example.myapplication.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharactersUseCase (val repository: CharacterRepository){
    operator fun invoke(): Flow<Characters>{
        return repository.getCharacterRepository()
    }
}