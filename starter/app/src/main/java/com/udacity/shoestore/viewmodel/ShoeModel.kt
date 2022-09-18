package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeModel : ViewModel() {

    private var _shoeList = mutableListOf<Shoe>(Shoe("Shoe1", "36.5", "Adidas", "Brown Color"), Shoe("Shoe2", "42.5", "Nike", "White Color"), Shoe("Shoe3", "32.5", "Puma", "Black Color"))

    private var _innerShoeData = MutableLiveData<List<Shoe>>()

    val shoeData: LiveData<List<Shoe>>
        get() = _innerShoeData

    private var _shoeAdded = MutableLiveData<Boolean>()

    val isShoeAdded: LiveData<Boolean>
    get() = _shoeAdded

    init {
        _innerShoeData.value = _shoeList
        _shoeAdded.value = false
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.add(Shoe(shoe.name, shoe.size, shoe.company, shoe.description))
        _shoeAdded.value = true
    }

    fun reset(){
        _shoeAdded.value = false
    }
}