package com.example.myapplication.home.presentation.state

import com.example.myapplication.domain.model.Characters

sealed class ResourceState {
    data class Success(val listCharacters: Characters): ResourceState()
    data class Error(val messageError: String = String()): ResourceState()
    data class Loading(val isLoading: Boolean): ResourceState()
}