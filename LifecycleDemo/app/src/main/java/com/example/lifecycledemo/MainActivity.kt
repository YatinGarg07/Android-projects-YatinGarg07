package com.example.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.inflate
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.example.lifecycledemo.databinding.MainActivityBinding
import com.example.lifecycledemo.databinding.MainActivityBinding.inflate
import com.example.lifecycledemo.databinding.MainFragmentBinding.inflate
import com.example.lifecycledemo.ui.main.MainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
private lateinit var progress : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        progress = findViewById(R.id.progressBar)

    }
}