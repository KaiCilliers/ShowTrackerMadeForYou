package com.sunrisekcdevelopers.showtracker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunrisekcdevelopers.logging.timber
import com.sunrisekcdevelopers.showtracker.databinding.ActivityMainBinding
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.MediaQuickSummary
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.MediaQuickSummary.Movie
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val log by timber()
    private val binding by viewBinding(ActivityMainBinding::inflate)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())
        log.i("onCreate")
        binding.testText.text = "noice"
        binding.ratingbar.setRating(8.4f)
        binding.media.submitModel(
            Movie(
                id = "",
                title = "my title",
                posterUrl = "https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e",
                directedBy = "stephen hawking",
                year = "1995",
                rating = 10f,
                runtime = 888f
            )
        )
    }
}