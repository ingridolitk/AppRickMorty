package com.example.myapplication.details.presentation.state

import com.example.myapplication.details.data.model.DetailsCharacters

sealed class DetailsResourceState {
    data class Success(val listCharacters: DetailsCharacters): DetailsResourceState()
    data class Error(val messageError: String = String()): DetailsResourceState()
    data class Loading(val isLoading: Boolean): DetailsResourceState()
}