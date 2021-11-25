package com.example.roomdemo.db

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SubscriberViewModel(private  val repository: SubscriberRepository) :ViewModel() {

    val subscribers = repository.subscribers
    private  var isUpdateOrDelete = false
    private lateinit var  subscriberToUpdateDelete : Subscriber

    val inputName = MutableLiveData<String?>()

    val inputEmail = MutableLiveData<String?>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage= MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
    get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){

        if(inputName.value==null){
            statusMessage.value = Event("Please enter subscriber's name")
        }
        else if(inputEmail.value==null){
            statusMessage.value = Event("Please enter subscriber's email")
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()){
            statusMessage.value = Event("Please enter a correct email address")
        }else{
            if(isUpdateOrDelete){
                subscriberToUpdateDelete.name = inputName.value!!
                subscriberToUpdateDelete.email = inputEmail.value!!
                update(subscriberToUpdateDelete)
            }
            else{

                if(!inputName.value.isNullOrEmpty()&&!inputEmail.value.isNullOrEmpty())
                {val name = inputName.value!!
                    val email  = inputEmail.value!!
                    insert(Subscriber (0,name,email))}

                inputName.value = null
                inputEmail.value = null}
        }

    }

    fun clearAllOrDelete(){
        if(isUpdateOrDelete){
        delete(subscriberToUpdateDelete)
        }
        else clearAll()
    }

    fun initUpdateAndDelete(subscriber: Subscriber){
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete =true
        subscriberToUpdateDelete =subscriber
        saveOrUpdateButtonText.value ="Update"
        clearAllOrDeleteButtonText.value ="Delete"
    }

    fun insert(subscriber: Subscriber) =  viewModelScope.launch {
            repository.insert(subscriber)

        }

    fun update(subscriber: Subscriber ) = viewModelScope.launch {
        repository.update(subscriber)
        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value ="Save"
        clearAllOrDeleteButtonText.value ="Clear all"
        statusMessage.value = Event("Subscriber Updated successfully")
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value ="Save"
        clearAllOrDeleteButtonText.value ="Clear all"
        statusMessage.value = Event("Subscriber Deleted successfully")
    }

    fun clearAll() = viewModelScope.launch { repository.deleteAll()
        statusMessage.value = Event("All Subscriber Deleted successfully")
    }



}