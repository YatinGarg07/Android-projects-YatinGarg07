package com.example.greetings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.click_me)
        button.setOnClickListener {

            editText = findViewById(R.id.EnterYourName)
            val name = editText.text
            Toast.makeText(this, "Good morning $name", Toast.LENGTH_SHORT).show()
        }

    }


}