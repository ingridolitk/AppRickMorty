package com.example.myapplication.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecase.DetailsCharacterUseCase
import com.example.myapplication.utils.DetailsCharacterState
import kotlinx.coroutines.launch

class DetailsCharacterViewModel(private val useCase: DetailsCharacterUseCase): ViewModel() {

    private val _detailsCharacter =  MutableLiveData<DetailsCharacterState>()
    val detailsCharacter: LiveData<DetailsCharacterState> = _detailsCharacter

    fun fetchDetailsCharacters() {
        viewModelScope.launch {
            _detailsCharacter.value = DetailsCharacterState.Loading(isLoading = IS_LOADING)
            _detailsCharacter.value = try {
                DetailsCharacterState.ResponseData(useCase.invoke())
            } catch (e: Exception) {
                DetailsCharacterState.Error(e.localizedMessage)
            }
        }
    }

}
private const val IS_LOADING = true
