package com.example.myapplication.details.di

import com.example.myapplication.details.data.detaisdatasource.DetailsDataSource
import com.example.myapplication.details.data.detaisdatasource.DetailsDataSourceImpl
import com.example.myapplication.details.data.repository.DetailsRepositoryImpl
import com.example.myapplication.details.domain.repository.DetailsRepository
import com.example.myapplication.details.domain.usecase.DetailsCharacterUseCase
import com.example.myapplication.details.presentation.details.DetailsCharacterViewModel
import com.example.myapplication.home.data.api.RetrofitService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DetailsModule {
    val detailsInstance = module {

        factory { RetrofitService().createRetrofit() }
        factory { DetailsCharacterUseCase(repository = get()) }
        factory<DetailsDataSource> { DetailsDataSourceImpl(api = get()) }
        factory <DetailsRepository>{ DetailsRepositoryImpl(detailsDataSource = get()) }

        viewModel {
            DetailsCharacterViewModel(detailsUseCase = get())
        }
    }
}