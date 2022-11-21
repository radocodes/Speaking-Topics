package com.example.speakingtopics

import android.app.Application
import com.example.speakingtopics.di.networkModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                networkModule
            )
        }
    }
}