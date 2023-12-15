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

class WorkoutViewModel : ViewModel() {
    //Attributes.
    //Current exercise.
    private val _currentExercise = MutableLiveData<Int>()
    val currentExercise: LiveData<Int> = _currentExercise

    //Doing exercise.
    private val _isExercising = MutableLiveData<Boolean>()
    val isExercising: LiveData<Boolean> = _isExercising

    //Methods.
    //This method will execute when this class is instanced.
    init {
        //Coroutine: coroutineScope
        viewModelScope.launch {

        }
    }

    //Method to start exercise.
    fun startExercise(numRepetitions: Int, updateNumRepetitions: Unit) {
        //Create a drawables' list that contains all gifs.
        //Update isExercising to indicate that an exercise is being made.
        //Update currentExercise with a random drawable from the previous list.
        //Coroutine with a loop that will repeat while "isExercising" is true.
        viewModelScope.launch {
            while(_isExercising.value == true) {
                //Waits 2 seconds.
                delay(2000)
                if (numRepetitions != 0) {
                    //Subtracts one from numRepetitions.
                    updateNumRepetitions
                } else {
                    //Restarts numRepetitions
                    //Updates currentExercise with a random drawable from the previous list.
                }
            }
        }

    }

    //Method to stop exercise.
    fun stopExercise() {

    }
}