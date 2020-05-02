package com.d3if1039.asmaulhusna.listview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3if1039.asmaulhusna.network.AsmaulHusnaApiService
import com.d3if1039.asmaulhusna.network.AsmaulHusnaProperty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListviewViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getDataAsmaulHusna()
    }

    private fun getDataAsmaulHusna() {
        AsmaulHusnaApiService.AsmaulHusnaApi.retrofitService.getProperties().enqueue(
            object : Callback<List<AsmaulHusnaProperty>>{
                override fun onFailure(call: Call<List<AsmaulHusnaProperty>>, t: Throwable) {
                    _response.value = "Failure" + t.message
                }

                override fun onResponse(call: Call<List<AsmaulHusnaProperty>>, response: Response<List<AsmaulHusnaProperty>>) {
                    _response.value = "Success : ${response.body()?.size} Asmaul Husna Property retrieved"
                }

            }
        )
    }
}