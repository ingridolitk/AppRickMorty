package com.example.myapplication.data.repository

import com.example.myapplication.data.datasource.CharacterDataSource
import com.example.myapplication.data.mapper.CharactersMapper
import com.example.myapplication.data.model.CharactersResponse
import com.example.myapplication.domain.model.Characters
import com.example.myapplication.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepositoryImpl(
    private val dataSource: CharacterDataSource,
    private val charactersMapper: CharactersMapper
) : CharacterRepository {

    override fun getCharacterRepository(): Flow<Characters> {
        return dataSource.getCharacters().map (charactersMapper::map)
        }
    }