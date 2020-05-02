package com.d3if1039.asmaulhusna.network

import com.squareup.moshi.Json

data class AsmaulHusnaProperty(
    val id : String,
    val judul : String,
    val arti : String,
    val keterangan : String,
    val perilaku : String,
    @Json(name = "imgURL")
    val imgSrcUrl : String
)