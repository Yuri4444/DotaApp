package com.berezhnoyyuri9999.di

import com.berezhnoyyuri9999.ui.main.MainFragment
import com.berezhnoyyuri9999.ui.main.MainFragmentViewModel
import org.koin.dsl.module

val fragmentsModule = module {
    factory { MainFragment() }
    factory { MainFragmentViewModel(get()) }
}