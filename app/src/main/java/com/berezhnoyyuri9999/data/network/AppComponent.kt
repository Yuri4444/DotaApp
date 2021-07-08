package com.berezhnoyyuri9999.data.network

import com.berezhnoyyuri9999.ui.main.MainFragment
import dagger.Component

@Component(modules = [NetworkModule::class, AppInterceptor::class])
interface  AppComponent {

//    fun getNetworkModule(): NetworkModule
    fun provideToMainFragment(mainFragment: MainFragment)
}