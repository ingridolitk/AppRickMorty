package com.example.myapplication.home.module.di

import android.app.Application
import com.example.myapplication.home.module.di.CharactersModule.instance
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
            loadKoinModules(instance)
        }
    }
}