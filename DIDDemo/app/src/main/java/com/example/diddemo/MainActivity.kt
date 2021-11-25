package com.example.diddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diddemo.R
import javax.inject.Inject

class  MainActivity : AppCompatActivity() {
    @Inject
    lateinit var  smartPhone: SmartPhone
    @Inject
    lateinit var memoryCard: MemoryCard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as SmartPhoneApplication).smartPhoneComponent.inject(this)
        smartPhone.makeACallWithRecording()

    }
}
