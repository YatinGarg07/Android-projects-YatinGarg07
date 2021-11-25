package com.example.coroutinespractice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch{
            Log.d("General" , "Thread ${Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.IO).launch{
            Log.d("General" , "Thread ${Thread.currentThread().name}")
        }





    }
}