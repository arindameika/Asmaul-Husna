package com.d3if1039.asmaulhusna.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.d3if1039.asmaulhusna.databinding.RecyclerviewListItemBinding
import com.d3if1039.asmaulhusna.network.AsmaulHusnaProperty

class ListViewAdapter(private val onClickListener: OnClickListener) : ListAdapter<AsmaulHusnaProperty,
        ListViewAdapter.AsmaulHusnaPropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewAdapter.AsmaulHusnaPropertyViewHolder {
        return AsmaulHusnaPropertyViewHolder(RecyclerviewListItemBinding.inflate(
            LayoutInflater.from(parent.context)
        ))
    }

    override fun onBindViewHolder(holder: ListViewAdapter.AsmaulHusnaPropertyViewHolder, position: Int){
        val asmaulHusnaProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(asmaulHusnaProperty)
        }
        holder.bind(asmaulHusnaProperty)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<AsmaulHusnaProperty>(){
        override fun areItemsTheSame(
            oldItem: AsmaulHusnaProperty,
            newItem: AsmaulHusnaProperty
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: AsmaulHusnaProperty,
            newItem: AsmaulHusnaProperty
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class AsmaulHusnaPropertyViewHolder(
        private var binding: RecyclerviewListItemBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(asmaulHusnaProperty: AsmaulHusnaProperty){
            binding.property = asmaulHusnaProperty
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (asmaulHusnaProperty:AsmaulHusnaProperty) -> Unit) {
        fun onClick(asmaulHusnaProperty: AsmaulHusnaProperty) = clickListener(asmaulHusnaProperty)
    }
}