package com.berezhnoyyuri9999.di

import com.berezhnoyyuri9999.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment

}