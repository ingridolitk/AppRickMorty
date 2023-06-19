package com.example.myapplication.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.CharactersResponse
import com.example.myapplication.data.state.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailsCharacterViewModel: ViewModel() {
    private val _detailsCharacter =  MutableLiveData<ResourceState>()
    val detailsCharacter: LiveData<ResourceState> = _detailsCharacter
}