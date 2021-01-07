package com.fernandodominguezpacheco.catlike.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernandodominguezpacheco.domain.Breed

class SharedViewModel: ViewModel() {

    private val selectedBreed = MutableLiveData<Breed>()

    fun selectBreed(breed: Breed){
        selectedBreed.value = breed
    }
    fun getSelectedBreed() : LiveData<Breed>{
        return selectedBreed
    }

}