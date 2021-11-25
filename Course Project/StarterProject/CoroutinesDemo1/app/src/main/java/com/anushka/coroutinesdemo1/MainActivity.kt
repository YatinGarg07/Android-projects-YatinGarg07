package com.anushka.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var btnCount: Button
    private lateinit var btnDownloadUserData: Button
    private lateinit var tvCount: TextView
    private lateinit var tvUserMessage: TextView


    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount = findViewById(R.id.btnCount)
        btnDownloadUserData = findViewById(R.id.btnDownloadUserData)
        tvCount = findViewById(R.id.tvCount)
        tvUserMessage=findViewById(R.id.tvUserMessage)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }



        btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {
                tvUserMessage.text=UserDataManger2().getTotalUserCount().toString()
            }

        }
    }

    private suspend fun downloadUserData() {

        for (i in 1..200000) {
            withContext(Dispatchers.Main){
            tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
        }
    }
    }
}
