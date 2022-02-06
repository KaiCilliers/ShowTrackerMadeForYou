package com.sunrisekcdevelopers.ui_components.components

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StPersonProfileBinding
import com.sunrisekcdevelopers.ui_components.withRecycle

@SuppressLint("Recycle")
class StPersonProfile @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StPersonProfileBinding = StPersonProfileBinding.inflate(LayoutInflater.from(context), this)

    init {
        context.obtainStyledAttributes(attrs, R.styleable.StPersonProfile).withRecycle {
            getString(R.styleable.StPersonProfile_stppPersonName)?.also { setPersonName(it) }
            getString(R.styleable.StPersonProfile_stppYearOfBirth)?.also { setYob(it) }
            getString(R.styleable.StPersonProfile_stppAddress)?.also { setAddress(it) }
            getString(R.styleable.StPersonProfile_stppCountry)?.also { setCountry(it) }
        }
    }

    fun setProfileImage(url: String) {
        binding.stPersonProfileImage.setImage(url)
    }

    fun setPersonName(name: String) {
        binding.stPersonProfileName.text = name
    }

    fun setYob(yob: String) {
        binding.stPersonProfileYob.text = yob
    }

    fun setAddress(address: String) {
        binding.stPersonProfileAddress.text = address
    }

    fun setCountry(country: String) {
        binding.stPersonProfileCountry.text = country
    }
}