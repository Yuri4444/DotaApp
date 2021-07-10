package com.berezhnoyyuri9999.data

import retrofit2.http.GET


interface Api {

    @GET("heroStats")
    suspend fun getHeroes() : List<HeroesList>

}