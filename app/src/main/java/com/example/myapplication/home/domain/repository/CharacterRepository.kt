package com.example.myapplication.home.domain.repository

import com.example.myapplication.home.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacterRepository() : Flow<Characters>
}