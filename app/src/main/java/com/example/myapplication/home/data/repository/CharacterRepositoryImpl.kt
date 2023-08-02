package com.example.myapplication.home.data.repository

import com.example.myapplication.home.data.datasource.CharacterDataSource
import com.example.myapplication.home.data.mapper.CharactersMapper
import com.example.myapplication.home.domain.model.Characters
import com.example.myapplication.home.domain.repository.CharacterRepository
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