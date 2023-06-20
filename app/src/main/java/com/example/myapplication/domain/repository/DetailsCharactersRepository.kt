package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Result


interface DetailsCharactersRepository {
    suspend fun getDetailsCharacters(): Result
}