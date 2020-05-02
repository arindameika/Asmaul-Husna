package com.d3if1039.asmaulhusna.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/arindameika/Asmaul-Husna/data_asmaul_husna/asmaul_husna_json/"

//Membuat object Moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Membuat objek retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

//buat interface untuk mendefinisikan bagaimana si retrofit berkomunikasi dengan web server menggunakan HTTP request
interface AsmaulHusnaApiService{

    @GET("asmaul_husna.json")
    fun getProperties(): Deferred<List<AsmaulHusnaProperty>>
    object AsmaulHusnaApi{
        val retrofitService : AsmaulHusnaApiService by lazy {
            retrofit.create(AsmaulHusnaApiService::class.java)
        }
    }
}