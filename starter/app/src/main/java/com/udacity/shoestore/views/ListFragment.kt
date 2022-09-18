package com.udacity.shoestore.views

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.databinding.LinearLayoutViewBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeModel

class ListFragment : Fragment(), MenuProvider {

    lateinit var shoeModel: ShoeModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentListBinding>(
            inflater, R.layout.fragment_list, container, false
        )

        binding.floatingActionButton.setOnClickListener {
            view!!.findNavController()
                .navigate(com.udacity.shoestore.views.ListFragmentDirections.actionListFragmentToDetailFragment())
        }

        shoeModel = ViewModelProvider(requireActivity()).get(ShoeModel::class.java)

        context?.let {
            for (shoe in shoeModel.shoeData.value!!) {
                addView(
                    binding.listLinearLayout,
                    it, shoe
                )
            }
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    fun addView(parent: ViewGroup, context: Context, shoe: Shoe) {

        val binding = DataBindingUtil.inflate<LinearLayoutViewBinding>(
            LayoutInflater.from(context), R.layout.linear_layout_view, parent, false
        )

        binding.linearlayoutName.setText(shoe.name)
        binding.linearlayoutSize.setText(shoe.size.toString())
        binding.linearlayoutCompany.setText(shoe.company)
        binding.linearlayoutDescription.setText(shoe.description)


        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )

        layoutParams.setMargins(16, 16, 16, 16)



        parent.addView(binding.root, layoutParams)

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(menuItem, view!!.findNavController())
    }

}