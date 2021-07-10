package com.berezhnoyyuri9999.data

import retrofit2.http.GET


interface Api {
//    https://cdn.cloudflare.steamstatic.com/apps/dota2/images/heroes/antimage_full.png
    @GET("heroStats")
    suspend fun getHeroes() : List<HeroesList>

}