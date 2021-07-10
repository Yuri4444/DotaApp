package com.berezhnoyyuri9999.di

import com.berezhnoyyuri9999.data.Api
import com.berezhnoyyuri9999.domain.Repository
import com.berezhnoyyuri9999.ui.main.MainFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(api: Api) = Repository(api)

    @Provides
    fun provideViewModel(repository: Repository) = MainFragmentViewModel(repository)

}