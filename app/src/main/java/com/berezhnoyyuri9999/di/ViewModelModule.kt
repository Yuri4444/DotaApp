package com.berezhnoyyuri9999.di

import androidx.lifecycle.ViewModelProvider
import com.berezhnoyyuri9999.ui.main.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}