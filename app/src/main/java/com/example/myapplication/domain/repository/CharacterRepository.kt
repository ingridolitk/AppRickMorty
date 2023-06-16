package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacterRepository() : Flow<Characters>
}