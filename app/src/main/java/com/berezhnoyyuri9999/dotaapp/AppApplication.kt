package com.berezhnoyyuri9999.dotaapp

import android.app.Application
import com.berezhnoyyuri9999.data.network.AppComponent
import com.berezhnoyyuri9999.data.network.DaggerAppComponent


class AppApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }


}