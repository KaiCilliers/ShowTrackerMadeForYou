package com.sunrisekcdevelopers.showtracker.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.showtracker.R
import com.sunrisekcdevelopers.showtracker.databinding.SecondaryActivityBinding
import com.sunrisekcdevelopers.showtracker.primary.SecondaryDestination
import com.sunrisekcdevelopers.showtracker.secondary.SecondaryOneFragment
import com.sunrisekcdevelopers.showtracker.secondary.SecondaryTwoFragment
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class SecondaryActivity : AppCompatActivity() {

    private val binding: SecondaryActivityBinding by viewBinding(SecondaryActivityBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        intent.getParcelableExtra<SecondaryDestination>("fragment")?.apply {
            when(this) {
                is SecondaryDestination.OnlyOne -> {
                    supportFragmentManager.beginTransaction()
                        .add(com.sunrisekcdevelopers.navigation.R.id.root_container, SecondaryOneFragment())
                        .commit()
                }
                SecondaryDestination.Two -> {
                    supportFragmentManager.beginTransaction()
                        .add(com.sunrisekcdevelopers.navigation.R.id.root_container, SecondaryTwoFragment())
                        .commit()
                }
            }
        }
    }

}