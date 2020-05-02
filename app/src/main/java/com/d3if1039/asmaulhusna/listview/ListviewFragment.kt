package com.d3if1039.asmaulhusna.listview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.d3if1039.asmaulhusna.R
import com.d3if1039.asmaulhusna.databinding.FragmentListviewBinding
import com.d3if1039.asmaulhusna.databinding.RecyclerviewListItemBinding

/**
 * A simple [Fragment] subclass.
 */
class ListviewFragment : Fragment() {

    private val viewModel: ListviewViewModel by lazy {
        ViewModelProviders.of(this).get(ListviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentListviewBinding.inflate(inflater)
//        val binding = RecyclerviewListItemBinding.inflate(inflater)

        binding.setLifecycleOwner (this)
        binding.viewModel = viewModel

        binding.rvItemList.adapter = ListViewAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
