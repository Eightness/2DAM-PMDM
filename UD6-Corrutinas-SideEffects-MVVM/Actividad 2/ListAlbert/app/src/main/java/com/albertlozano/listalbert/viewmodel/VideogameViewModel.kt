package com.albertlozano.listalbert.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertlozano.listalbert.model.Videogame
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VideogameViewModel : ViewModel() {
    //Video games list
    private val _videogames = MutableLiveData<List<Videogame>>()
    val videogame: LiveData<List<Videogame>> = _videogames

    //Selected video game
    private val _selectedVideogame = MutableLiveData<Videogame>()
    val selectedVideogame: LiveData<Videogame> = _selectedVideogame

    //Variable that indicates that we are obtaining data from repository
    private var _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    //When instantiating an object VideogameViewModel and calling the constructor, this block will execute:
    init {
        //Coroutine: coroutineScope
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _videogames.value = Videogame.getData()
            _isLoading.value = false
        }
    }

    //Methods

    fun deleteVideogame(videogame: Videogame) {
        _videogames.value = _videogames.value?.filter { it != videogame }
    }

    fun onVideogameClicked(videogame: Videogame) {
        _selectedVideogame.value = videogame
    }

    fun onFavoriteButtonClicked() {
        val auxVideogame = _selectedVideogame.value?.copy()
        auxVideogame?.favorite = !auxVideogame?.favorite!!
        _selectedVideogame.value = auxVideogame

        val auxList = mutableListOf<Videogame>()
        _videogames.value?.map { videogame ->
            if (auxVideogame.title == videogame.title) {
                videogame.favorite = !videogame.favorite
            }
            auxList.add(videogame)
        }
        _videogames.value = auxList
    }

//    fun increaseStock(quantity: Int) {
//        val updatedList = mutableListOf<Videogame>()
//        _videogames.value?.forEach {
//            val videogame = it.copy()
//            videogame.stock += quantity
//            updatedList.add(videogame)
//        }
//        _videogames.value = updatedList
//    }
}