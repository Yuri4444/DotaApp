package com.berezhnoyyuri9999.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.berezhnoyyuri9999.data.HeroesList
import com.berezhnoyyuri9999.domain.Repository
import com.example.autoapp.utils.extensions.viewModel.ioToUi
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

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


//    class Factory @Inject constructor(private val repository: Repository) : ViewModelProvider.Factory {
//        @Suppress("UNCHECKED_CAST")
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            require(modelClass == MainFragmentViewModel::class)
//            return MainFragmentViewModel(repository) as T
//        }
//
//    }
}