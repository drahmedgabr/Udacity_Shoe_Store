package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeModel : ViewModel() {

    private var _shoeList = mutableListOf<Shoe>(Shoe("Shoe1", 36.5, "Adidas", "Brown Color"), Shoe("Shoe2", 42.5, "Nike", "White Color"), Shoe("Shoe3", 32.5, "Puma", "Black Color"))

    private var _innerShoeData = MutableLiveData<List<Shoe>>()

    val shoeData: LiveData<List<Shoe>>
        get() = _innerShoeData

    init {
        _innerShoeData.value = _shoeList
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        _shoeList.add(Shoe(name, size, company, description))
    }
}