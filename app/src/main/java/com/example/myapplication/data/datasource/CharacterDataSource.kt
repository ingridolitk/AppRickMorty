package com.example.myapplication.data.datasource

import com.example.myapplication.data.model.CharactersResponse
import kotlinx.coroutines.flow.Flow

interface CharacterDataSource {

    fun getCharacters(): Flow<CharactersResponse>
}