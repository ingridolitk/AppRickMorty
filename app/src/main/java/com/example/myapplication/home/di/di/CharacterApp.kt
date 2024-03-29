package com.example.myapplication.home.di.di

import android.app.Application
import com.example.myapplication.details.di.DetailsModule.detailsInstance
import com.example.myapplication.home.di.di.CharactersModule.charactersInstance
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

class CharacterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(appDeclaration = KoinAppDeclarationProvider.get(this))
    }

    object KoinAppDeclarationProvider {

        fun get(application: Application): KoinAppDeclaration = {
            androidContext(application)
            loadKoinModules(charactersInstance)
            loadKoinModules(detailsInstance)
        }
    }
}