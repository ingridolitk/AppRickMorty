package com.example.myapplication.data.datasource

import com.example.myapplication.data.api.CartoonApi
import com.example.myapplication.data.model.CharactersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CharacterDataSourceImpl(private val service: CartoonApi): CharacterDataSource {

    override fun getCharacters(): Flow<CharactersResponse> {
        return flow{
            emit(service.characterRickyandMory())
        }
    }
}