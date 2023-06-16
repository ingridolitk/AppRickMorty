package com.example.myapplication.presentation.character

import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myapplication.data.model.CharactersResponse
import com.example.myapplication.data.state.ResourceState
import com.example.myapplication.domain.model.Characters
import com.example.myapplication.domain.repository.CharacterRepository
import com.example.myapplication.domain.usecase.CharactersUseCase
import com.example.myapplication.module.di.CharacterApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class CharactersViewModel(private val useCase: CharactersUseCase): ViewModel() {

    private val _descriptionCharacter = MutableStateFlow<ResourceState<Characters>>(ResourceState.Loading())
    val descriptionCharacter: StateFlow<ResourceState<Characters>> = _descriptionCharacter

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