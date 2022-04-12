package com.dimaszulfa.movie

import android.app.Application
import com.dimaszulfa.movie.di.homeModule
import com.dimaszulfa.movie.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(homeModule, networkModule)
        }
    }
}