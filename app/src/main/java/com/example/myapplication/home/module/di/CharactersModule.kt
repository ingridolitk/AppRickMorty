package com.example.myapplication.home.module.di


import com.example.myapplication.home.data.api.RetrofitService
import com.example.myapplication.data.datasource.CharacterDataSource
import com.example.myapplication.data.datasource.CharacterDataSourceImpl
import com.example.myapplication.data.mapper.CharactersMapper
import com.example.myapplication.data.repository.CharacterRepositoryImpl
import com.example.myapplication.domain.repository.CharacterRepository
import com.example.myapplication.domain.usecase.CharactersUseCase
import com.example.myapplication.presentation.character.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object CharactersModule {

    val instance = module {

        factory { com.example.myapplication.home.data.api.RetrofitService().createRetrofit() }
        factory { CharactersUseCase(repository = get()) }
        factory<CharacterDataSource> { CharacterDataSourceImpl(service = get()) }
        factory { CharactersMapper() }
        factory<CharacterRepository> {CharacterRepositoryImpl(dataSource = get(),
            charactersMapper = get())
        }

        viewModel {
            CharactersViewModel(useCase = get())
        }
    }
}