package com.berezhnoyyuri9999.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.berezhnoyyuri9999.domain.Repository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val newsRepository: Repository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainFragmentViewModel(newsRepository) as T
    }

}
