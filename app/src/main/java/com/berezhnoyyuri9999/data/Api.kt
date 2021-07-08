package com.berezhnoyyuri9999.data

import retrofit2.http.GET


interface Api {

    @GET("heroes")
    fun getHeroes() : List<HeroesList>

}