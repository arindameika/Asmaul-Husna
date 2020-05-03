package com.d3if1039.asmaulhusna.detailview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.d3if1039.asmaulhusna.network.AsmaulHusnaProperty

class DetailViewModel(asmaulHusnaProperty: AsmaulHusnaProperty,
                      app: Application) : AndroidViewModel(app) {
    private val _selectedItem = MutableLiveData<AsmaulHusnaProperty>()
    val selectedItem : LiveData<AsmaulHusnaProperty>
        get() = _selectedItem

    init {
        _selectedItem.value = asmaulHusnaProperty
    }
}