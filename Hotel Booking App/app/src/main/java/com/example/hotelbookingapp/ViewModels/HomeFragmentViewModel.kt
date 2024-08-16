package com.example.hotelbookingapp.ViewModels

import android.app.DatePickerDialog
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar
import java.util.Date

class HomeFragmentViewModel:ViewModel() {

    var counterGuestsLiveData : MutableLiveData<Int> = MutableLiveData()
    var counterRoomsLiveData : MutableLiveData<Int> = MutableLiveData()

//    Counter work of Guests and Rooms
    init {
        counterGuestsLiveData.value = 1
        counterRoomsLiveData.value = 1
    }

    fun incrementCountGuestsValue(){
        if(counterGuestsLiveData.value!! >= 0) {
            counterGuestsLiveData.value = counterGuestsLiveData.value?.plus(1)
        }
    }

    fun decrementCountGuestsValue(){
        if(counterGuestsLiveData.value!! > 0) {
            counterGuestsLiveData.value = counterGuestsLiveData.value?.minus(1)
        }
    }

    fun incrementCountRoomsValue(){
        if(counterRoomsLiveData.value!! >= 0) {
            counterRoomsLiveData.value = counterRoomsLiveData.value?.plus(1)
        }
    }

    fun decrementCountRoomsValue(){
        if(counterRoomsLiveData.value!! > 0){
            counterRoomsLiveData.value = counterRoomsLiveData.value?.minus(1)
        }
    }

}