package com.d3if1039.asmaulhusna

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.d3if1039.asmaulhusna.listview.AsmaulHusnaApiStatus
import com.d3if1039.asmaulhusna.listview.ListViewAdapter
import com.d3if1039.asmaulhusna.network.AsmaulHusnaProperty

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri()
            .buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<AsmaulHusnaProperty>?){
    val adapter = recyclerView.adapter as ListViewAdapter
    adapter.submitList(data)
}

@BindingAdapter("asmaulHusnaApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: AsmaulHusnaApiStatus?) {
    when (status) {
        AsmaulHusnaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        AsmaulHusnaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        AsmaulHusnaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}