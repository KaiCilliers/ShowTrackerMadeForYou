package com.sunrisekcdevelopers.showtracker.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sunrisekcdevelopers.showtracker.PrimaryDestinationsContainer
import com.sunrisekcdevelopers.showtracker.databinding.PrimaryActivityBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class PrimaryActivity : AppCompatActivity() {

    private val binding: PrimaryActivityBinding by viewBinding(PrimaryActivityBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            // add container fragment for primary navigation
           supportFragmentManager.beginTransaction()
               .add(com.sunrisekcdevelopers.navigation.R.id.root_container, PrimaryDestinationsContainer())
               .commit()
        }
    }

}