package com.example.myapplication.details.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.details.domain.usecase.DetailsCharacterUseCase
import com.example.myapplication.details.presentation.state.DetailsResourceState
import kotlinx.coroutines.launch

class DetailsCharacterViewModel(private val detailsUseCase: DetailsCharacterUseCase): ViewModel() {

    private val _descriptionDetails = MutableLiveData<DetailsResourceState>()
    val descriptionDetails: LiveData<DetailsResourceState> = _descriptionDetails

    private val _error: MutableLiveData<String> = MutableLiveData()
    var error: LiveData<String> = _error

    fun fetchDetailsMovies(id: Int) {
        viewModelScope.launch {
            _descriptionDetails.value = DetailsResourceState.Loading(isLoading = true)
            _descriptionDetails.value = try {
                DetailsResourceState.Success(detailsUseCase.invoke(id = id))
            } catch (e: Exception) {
                DetailsResourceState.Error(e.localizedMessage)
            }
            _descriptionDetails.value = DetailsResourceState.Loading(isLoading = false)
        }
    }

}