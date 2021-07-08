package com.berezhnoyyuri9999.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berezhnoyyuri9999.data.HeroesList
import com.berezhnoyyuri9999.domain.Repository
import com.example.autoapp.utils.extensions.viewModel.ioToUi

class MainFragmentViewModel(private val repository: Repository) : ViewModel() {

    val heroesList = MutableLiveData<List<HeroesList>>()

//    suspend fun getHeroes() = repository.getHeroes()

    fun fetch() {
        ioToUi(
            io = {
                 val result = repository.getHeroes()
                result
            },
            ui = {
                heroesList.value = it
            }
        )
    }
}