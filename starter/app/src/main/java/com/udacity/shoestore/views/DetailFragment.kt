package com.udacity.shoestore.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeModel


class DetailFragment : Fragment() {

    lateinit var shoeModel: ShoeModel
    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater, R.layout.fragment_detail, container, false
        )

        binding.shoe = Shoe()

        binding.addButton.setOnClickListener {
            shoeModel.addShoe(binding.shoe!!)
        }

        binding.cancelButton.setOnClickListener {
            navigateUp()
        }

        shoeModel = ViewModelProvider(requireActivity()).get(ShoeModel::class.java)

        shoeModel.isShoeAdded.observe(this, Observer { hasAdded ->
            if(hasAdded) {
                navigateUp()
                Toast.makeText(context, "Shoe Added", Toast.LENGTH_LONG).show()
                shoeModel.reset()
            }
        })

        return binding.root

    }

    fun navigateUp(){
        view!!.findNavController().navigateUp()
    }
}