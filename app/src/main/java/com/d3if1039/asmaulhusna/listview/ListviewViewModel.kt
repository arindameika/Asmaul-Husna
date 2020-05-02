package com.d3if1039.asmaulhusna.listview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3if1039.asmaulhusna.network.AsmaulHusnaApiService
import com.d3if1039.asmaulhusna.network.AsmaulHusnaProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class ListviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob +  Dispatchers.Main)

    private val _properties = MutableLiveData<List<AsmaulHusnaProperty>>()
    val properties: LiveData<List<AsmaulHusnaProperty>>
        get() = _properties

    init {
        getDataAsmaulHusna()
    }

    private fun getDataAsmaulHusna() {
        coroutineScope.launch {
            var getPropertiesDeffered = AsmaulHusnaApiService.AsmaulHusnaApi.retrofitService.getProperties()
            try {
                var listResult = getPropertiesDeffered.await()
                _response.value = "Success: ${listResult.size} Asmaul Husna properties retrieved"
                if (listResult.size > 0){
                    _properties.value = listResult
                }
            } catch (e: Exception){
                _response.value = "Failed: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}