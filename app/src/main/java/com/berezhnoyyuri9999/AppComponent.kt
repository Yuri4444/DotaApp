package com.berezhnoyyuri9999

import android.app.Application
import com.berezhnoyyuri9999.di.*
import com.berezhnoyyuri9999.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        FragmentModule::class,
        AndroidInjectionModule::class,

    RepositoryModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: AppApplication)
    fun inject(mainFragment: MainFragment)
}