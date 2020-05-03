package com.d3if1039.asmaulhusna.detailview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.d3if1039.asmaulhusna.network.AsmaulHusnaProperty

class DetailViewModelFactory(
    private val asmaulHusnaProperty: AsmaulHusnaProperty,
    private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(asmaulHusnaProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}