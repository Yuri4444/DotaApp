package com.berezhnoyyuri9999.domain

import com.berezhnoyyuri9999.data.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val api: Api) {

    suspend fun getHeroes() = api.getHeroes()

}