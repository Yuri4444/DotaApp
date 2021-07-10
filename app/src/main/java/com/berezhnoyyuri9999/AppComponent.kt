package com.berezhnoyyuri9999

import com.berezhnoyyuri9999.data.network.NetworkModule
import com.berezhnoyyuri9999.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent  {
    fun inject(mainFragment: MainFragment)
//fun inject(appApplication: AppApplication)
}