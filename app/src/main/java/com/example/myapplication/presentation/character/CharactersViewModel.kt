package com.example.myapplication.presentation.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.state.ResourceState
import com.example.myapplication.domain.usecase.CharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class CharactersViewModel(private val useCase: CharactersUseCase): ViewModel() {

    private val _descriptionCharacter = MutableLiveData<ResourceState>()
    val descriptionCharacter: LiveData<ResourceState> = _descriptionCharacter

    private val _error: MutableLiveData<String> = MutableLiveData()
    var error: LiveData<String> = _error

    fun getCharacters() {
        viewModelScope.launch {
            useCase.invoke().flowOn(Dispatchers.IO)
                .catch { error ->
                    _error.value = error.message
                }
                .collect {
                      _descriptionCharacter.value = ResourceState.Success(it)
                }
        }
    }
}