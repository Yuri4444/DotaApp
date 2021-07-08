package com.berezhnoyyuri9999.domain

import androidx.lifecycle.MutableLiveData
import com.berezhnoyyuri9999.data.Api
import com.berezhnoyyuri9999.data.HeroesList

class Repository(private val api: Api) {

    suspend fun getHeroes() = api.getHeroes()

}