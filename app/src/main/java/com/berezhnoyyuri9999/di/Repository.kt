package com.berezhnoyyuri9999.di

import com.berezhnoyyuri9999.domain.Repository
import org.koin.dsl.module

val repositoryModule = module {
    factory { Repository(get()) }
}