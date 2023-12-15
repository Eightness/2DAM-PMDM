/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.workoutalbert.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CommonViewModel : ViewModel() {
    //Attributes.
    //User's name.
    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    //Number of repetitions.
    private val _numRepetitions = MutableLiveData<Int>()
    val numRepetitions: LiveData<Int> = _numRepetitions

    //Methods.
    //This method will execute when this class is instanced.
    init {
        //Coroutine: coroutineScope
        viewModelScope.launch {

        }
    }

    //Method to update user's name.
    fun updateUserName(userName: String) {
        _userName.value = userName
    }

    //Method to update number of repetitions.
    fun updateNumRepetitions(numRepetitions: Int) {
        _numRepetitions.value = numRepetitions
    }
}