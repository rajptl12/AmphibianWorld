package com.raj.amphibianworld

import android.app.Application
import com.raj.amphibianworld.data.AmphibianRepository

class MainApplication : Application() {

    val amphibianRepo: AmphibianRepository by lazy {
        AmphibianRepository()
    }

    override fun onCreate() {
        super.onCreate()
        // Optional: Add logging or analytics setup here later
    }
}
