package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentListBinding>(
            inflater, R.layout.fragment_list, container, false
        )

        binding.floatingActionButton.setOnClickListener {
            view!!.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        }

        return binding.root
    }

}