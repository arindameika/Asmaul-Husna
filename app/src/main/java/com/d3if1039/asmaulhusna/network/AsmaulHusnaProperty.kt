package com.d3if1039.asmaulhusna.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AsmaulHusnaProperty(
    @Json(name = "id")
    val id : String,

    @Json(name = "judul")
    val judul : String,

    @Json(name = "arti")
    val arti : String,

    @Json(name = "keterangan")
    val keterangan : String,

    @Json(name = "perilaku")
    val perilaku : String,

    @Json(name = "imgURL")
    val imgSrcUrl : String) : Parcelable {

}