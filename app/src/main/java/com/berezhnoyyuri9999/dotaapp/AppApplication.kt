package com.berezhnoyyuri9999.dotaapp

import android.app.Application
import com.berezhnoyyuri9999.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class AppApplication : Application() {

//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

//        appComponent = DaggerAppComponent.create()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(listOf(networkModule, repositoryModule, activityModule, fragmentsModule))
        }



    }


}