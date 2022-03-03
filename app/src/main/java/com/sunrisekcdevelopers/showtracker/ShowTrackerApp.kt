package com.sunrisekcdevelopers.showtracker

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ShowTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        // See more features of Koin here https://www.droidcon.com/2021/11/09/android-architecture-design-with-koin/
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@ShowTrackerApp)
        }
    }
}