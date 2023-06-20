package com.example.myapplication.utils

import com.example.myapplication.domain.model.Result

sealed class DetailsCharacterState {
    data class Loading(val isLoading: Boolean) : DetailsCharacterState()
    data class ResponseData(val details: Result) : DetailsCharacterState()
    data class Error(val error: String?) : DetailsCharacterState()
}