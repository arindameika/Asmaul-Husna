package com.d3if1039.asmaulhusna.detailview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.d3if1039.asmaulhusna.R
import com.d3if1039.asmaulhusna.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)

        return binding.root
    }

}
