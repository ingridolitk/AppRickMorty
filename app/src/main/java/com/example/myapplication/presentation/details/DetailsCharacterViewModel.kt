package com.example.myapplication.presentation.details

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.CharactersResponse
import com.example.myapplication.data.state.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailsCharacterViewModel: ViewModel() {
    private val _detailsCharacter = MutableStateFlow<ResourceState<CharactersResponse>>(ResourceState.Loading())
    val detailsCharacter: StateFlow<ResourceState<CharactersResponse>> = _detailsCharacter

}