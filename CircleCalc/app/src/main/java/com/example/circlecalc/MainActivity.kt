package com.example.circlecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.circlecalc.databinding.ActivityMainBinding

const val PIE = 3.14
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.calculateButton.setOnClickListener {
            val rad :Double = binding.radiusEditText.text.toString().toDouble()
            binding.areaTextview.text = "Area :\n"+calculateArea(rad).toString()
            binding.circumfrenceTextView.text = "Circumfrence\n"+calculateCircumFrence(rad).toString()
        }

    }

    private fun calculateArea(radius : Double) : Double{
        return PIE*radius*radius
    }
    private fun calculateCircumFrence(radius : Double) : Double{
        return 2*PIE*radius
    }
}