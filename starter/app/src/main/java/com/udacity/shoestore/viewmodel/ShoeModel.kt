package com.udacity.shoestore.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeModel : ViewModel() {

    private var _shoeList = mutableListOf<Shoe>(
        Shoe("Shoe1", "36.5", "Adidas", "Brown Color"),
        Shoe("Shoe2", "42.5", "Nike", "White Color"),
        Shoe("Shoe3", "32.5", "Puma", "Black Color")
    )

    private var _innerShoeData = MutableLiveData<List<Shoe>>()

    val shoeData: LiveData<List<Shoe>>
        get() = _innerShoeData

    private var _shoeAdded = MutableLiveData<Boolean>()

    val isShoeAdded: LiveData<Boolean>
        get() = _shoeAdded

    init {
        _innerShoeData.value = _shoeList
        reset()
    }

    fun addShoe(context: Context, shoe: Shoe) {
        if (shoe.name.equals("") || shoe.size.equals("") || shoe.company.equals("") || shoe.description.equals(
                ""
            )
        ) {
            Toast.makeText(context, R.string.toast_empty, Toast.LENGTH_LONG).show()
            return
        }
        _shoeList.add(Shoe(shoe.name, shoe.size, shoe.company, shoe.description))
        _shoeAdded.value = true
    }

    fun reset() {
        _shoeAdded.value = false
    }
}