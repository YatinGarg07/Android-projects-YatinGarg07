package com.anushka.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
     var total = MutableLiveData<Int>()
    var stillNum = MutableLiveData<String>()

    init {
        total.value = startingTotal
    }

    fun setTotal(){
        val intInput : Int = stillNum.value!!.toInt()
        total.value =(total.value)?.plus(intInput)
    }
}