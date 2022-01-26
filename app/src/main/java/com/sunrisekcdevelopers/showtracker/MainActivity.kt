package com.sunrisekcdevelopers.showtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunrisekcdevelopers.logging.timber
import com.sunrisekcdevelopers.showtracker.databinding.ActivityMainBinding
import com.sunrisekcdevelopers.ui_components.viewBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val log by timber()
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        log.i("onCreate")
        binding.testText.text = "noice"
    }
}