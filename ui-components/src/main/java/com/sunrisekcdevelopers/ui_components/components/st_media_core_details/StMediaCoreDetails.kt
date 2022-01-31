package com.sunrisekcdevelopers.ui_components.components.st_media_core_details

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.MediaQuickSummary.Movie
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.MediaQuickSummary.TVShow
import com.sunrisekcdevelopers.ui_components.databinding.StMediaCoreDetailsBinding
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.valid
import com.sunrisekcdevelopers.ui_components.visible

class StMediaCoreDetails @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StMediaCoreDetailsBinding = StMediaCoreDetailsBinding.inflate(LayoutInflater.from(context), this)
    private lateinit var model: MediaQuickSummary

    private fun setMovieData() {
        // todo convert runtime float (maybe keep as int) to hh:mm format
        binding.stMediaMainDetailsRuntime.text = (model as Movie).runtime.toString()
        binding.stMediaMainDetailsRuntime.visible()
    }

    private fun setTVShowData() {
        binding.stMediaMainDetailsStatus.text = (model as TVShow).status.name
        binding.stMediaMainDetailsStatus.visible()
    }

    @SuppressLint("SetTextI18n")
    fun submitModel(model: MediaQuickSummary) {
        this.model = model
        when(model) {
            is Movie -> setMovieData()
            is TVShow -> setTVShowData()
        }
        model.apply {
            binding.stMediaMainDetailsTitle.text = title

            year.valid (
                yes = { binding.stMediaMainDetailsYearDirectedBy.text = it },
                no = { binding.stMediaMainDetailsYearDirectedBy.gone() }
            )

            directedBy.valid(
                yes = {
                      year.valid(
                          // todo replace with string resource
                          yes = { binding.stMediaMainDetailsYearDirectedBy.append(" · Directed by") },
                          no = { binding.stMediaMainDetailsYearDirectedBy.text = "Directed by" }
                      )
                    binding.stMediaMainDetailsDirector.text = it
                },
                no = { binding.stMediaMainDetailsDirector.gone() }
            )

            rating.valid(
                yes = { binding.stMediaMainDetailsRatingBar.setRating(it) },
                no = { binding.stMediaMainDetailsRatingBar.gone() }
            )

            posterUrl.let {
                // this image loading class needs to be injected (constructor)
                StandardGlideImage().load(
                    context = context,
                    imgSrc = it,
                    targetView = binding.stMediaMainDetailsPoster
                )
            }
        }
    }

}