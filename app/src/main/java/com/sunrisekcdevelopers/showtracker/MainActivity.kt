package com.sunrisekcdevelopers.showtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunrisekcdevelopers.logging.timber
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val log by timber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        log.i("onCreate")
    }
}