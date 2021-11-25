package com.example.twowaydemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val username = MutableLiveData<String>()
    val userData : LiveData<String>
    get() = username

    init {
        username.value="Frank"
    }

}