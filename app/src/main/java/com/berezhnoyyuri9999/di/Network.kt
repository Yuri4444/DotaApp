package com.berezhnoyyuri9999.di

import com.berezhnoyyuri9999.data.network.AppInterceptor
import com.berezhnoyyuri9999.data.network.provideApi
import com.berezhnoyyuri9999.data.network.provideOkHttpClient
import com.berezhnoyyuri9999.data.network.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { AppInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideApi(get()) }
    single { provideRetrofit(get()) }
}