package com.example.myapplication.home.di.di

import com.example.myapplication.home.data.datasource.CharacterDataSource
import com.example.myapplication.home.data.datasource.CharacterDataSourceImpl
import com.example.myapplication.home.data.mapper.CharactersMapper
import com.example.myapplication.home.domain.usecase.CharactersUseCase
import com.example.myapplication.home.presentation.character.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CharactersModule {

    val charactersInstance = module {

        factory { com.example.myapplication.home.data.api.RetrofitService().createRetrofit() }
        factory { CharactersUseCase(repository = get()) }
        factory<CharacterDataSource> { CharacterDataSourceImpl(service = get()) }
        factory { CharactersMapper() }

        viewModel {
            CharactersViewModel(useCase = get())
        }
    }
}