package com.udacity.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodel.ShoeModel


class DetailFragment : Fragment() {

    lateinit var shoeModel: ShoeModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater, R.layout.fragment_detail, container, false
        )

        shoeModel = ViewModelProvider(requireActivity()).get(ShoeModel::class.java)

        binding.shoeModel = shoeModel

        binding.cancelButton.setOnClickListener {
            navigateUp()
        }

        return binding.root

    }

    fun navigateUp(){
        view!!.findNavController().navigateUp()
    }

}