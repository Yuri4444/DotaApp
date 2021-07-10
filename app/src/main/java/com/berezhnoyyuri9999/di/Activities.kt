package com.berezhnoyyuri9999.di

import com.berezhnoyyuri9999.ui.MainActivity
import org.koin.dsl.module

val activityModule = module {
    factory { MainActivity() }
}