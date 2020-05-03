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

enum class AsmaulHusnaApiStatus { LOADING, ERROR, DONE }

class ListviewViewModel : ViewModel() {

    private val _status = MutableLiveData<AsmaulHusnaApiStatus>()
    val status: LiveData<AsmaulHusnaApiStatus>
        get() = _status

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob +  Dispatchers.Main)

    private val _properties = MutableLiveData<List<AsmaulHusnaProperty>>()
    val properties: LiveData<List<AsmaulHusnaProperty>>
        get() = _properties

    private val _navigateToSelectedItem = MutableLiveData<AsmaulHusnaProperty>()
    val navigateToSelectedItem : LiveData<AsmaulHusnaProperty>
        get() = _navigateToSelectedItem

    init {
        getDataAsmaulHusna()
    }

    private fun getDataAsmaulHusna() {
        coroutineScope.launch {
            var getPropertiesDeffered = AsmaulHusnaApiService.AsmaulHusnaApi.retrofitService.getProperties()
            try {
                _status.value = AsmaulHusnaApiStatus.LOADING
                var listResult = getPropertiesDeffered.await()
                _status.value = AsmaulHusnaApiStatus.DONE
                if (listResult.size > 0){
                    _properties.value = listResult
                }
            } catch (e: Exception){
                _status.value = AsmaulHusnaApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun displayItemDetails(asmaulHusnaProperty: AsmaulHusnaProperty){
        _navigateToSelectedItem.value = asmaulHusnaProperty
    }

    fun displayItemDetailsComplete() {
        _navigateToSelectedItem.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}