package com.sunrisekcdevelopers.ui_components.components

import android.annotation.SuppressLint
import android.content.Context
import android.transition.TransitionManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.google.android.material.shape.ShapeAppearanceModel
import com.sunrisekcdevelopers.imageloading.StandardGlideImage
import com.sunrisekcdevelopers.ui_components.R
import com.sunrisekcdevelopers.ui_components.databinding.StPosterBinding
import com.sunrisekcdevelopers.ui_components.gone
import com.sunrisekcdevelopers.ui_components.visible
import com.sunrisekcdevelopers.ui_components.withRecycle

// you can extend and create some standard uses (like a circle crop or different poster sizes)
// maybe diff component for diff default behaviour
@SuppressLint("Recycle")
class StPoster @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    // todo different size posters
    private var iconPlacement: IconPlacement = IconPlacement.BottomRight
    private var cropType: CropType = CropType.Poster

    private val binding: StPosterBinding = StPosterBinding.inflate(LayoutInflater.from(context), this)

    init {
//        context.obtainStyledAttributes(attrs, R.styleable.StPoster).withRecycle {
//            getResourceId(R.styleable.StPoster_stpImgSrc, 0).also {
//                binding.stPosterImage.background = ContextCompat.getDrawable(context, it)
//            }
//        }
        StandardGlideImage().load(
            context = context,
            imgSrc = "https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e",
            targetView = binding.stPosterImage
        )
    }

    fun setOnActionIconClickListener(action: View.() -> Unit) {
        // also toggle drawable if needed
        binding.stPosterActionIcon.setOnClickListener { action(it) }
    }

    fun showActionIcon(show: Boolean = true) {
        if (show) binding.stPosterActionIcon.visible() else binding.stPosterActionIcon.gone()
    }

    // suspend for testing purposes
    suspend fun setCropType(type: CropType) {
        cropType = type
        cropImage()
    }

    @Suppress("RedundantSuspendModifier")
    private suspend fun cropImage() {
        TransitionManager.beginDelayedTransition(binding.root as ConstraintLayout)
        when (cropType) {
            CropType.Circle -> {
                binding.stPosterImage.shapeAppearanceModel = ShapeAppearanceModel.builder(
                    binding.stPosterImage.context,
                    0,
                    R.style.ShapeAppearanceOverlay_ShowTracker_Circle
                ).build()
            }
            CropType.Poster -> {
                binding.stPosterImage.shapeAppearanceModel = ShapeAppearanceModel.builder(
                    binding.stPosterImage.context,
                    0,
                    0
                ).build()
            }
        }
    }

    // suspend fun to test on loop with delay
    suspend fun setIconPlacement(location: IconPlacement) {
        iconPlacement = location
        moveActionIcon()
    }

    @Suppress("RedundantSuspendModifier")
    private suspend fun moveActionIcon() {
        val set = ConstraintSet()
        set.clone(binding.root as ConstraintLayout)
        set.clear(binding.stPosterActionIcon.id, ConstraintSet.TOP)
        set.clear(binding.stPosterActionIcon.id, ConstraintSet.BOTTOM)
        set.clear(binding.stPosterActionIcon.id, ConstraintSet.START)
        set.clear(binding.stPosterActionIcon.id, ConstraintSet.END)

        when (iconPlacement) {
            IconPlacement.BottomLeft -> {
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.BOTTOM,
                    binding.stPosterImage.id,
                    ConstraintSet.BOTTOM
                )
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.START,
                    binding.stPosterImage.id,
                    ConstraintSet.START
                )
            }
            IconPlacement.BottomRight -> {
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.BOTTOM,
                    binding.stPosterImage.id,
                    ConstraintSet.BOTTOM
                )
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.END,
                    binding.stPosterImage.id,
                    ConstraintSet.END
                )
            }
            IconPlacement.TopLeft -> {
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.TOP,
                    binding.stPosterImage.id,
                    ConstraintSet.TOP
                )
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.START,
                    binding.stPosterImage.id,
                    ConstraintSet.START
                )
            }
            IconPlacement.TopRight -> {
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.TOP,
                    binding.stPosterImage.id,
                    ConstraintSet.TOP
                )
                set.connect(
                    binding.stPosterActionIcon.id,
                    ConstraintSet.END,
                    binding.stPosterImage.id,
                    ConstraintSet.END
                )
            }
        }

        // simple one liner to animate moving the drawable icon
        TransitionManager.beginDelayedTransition(binding.root as ConstraintLayout)

        set.applyTo(binding.root as ConstraintLayout)
    }

    sealed class IconPlacement {
        object BottomRight : IconPlacement()
        object TopRight : IconPlacement()
        object TopLeft : IconPlacement()
        object BottomLeft : IconPlacement()
    }

    sealed class CropType {
        object Circle : CropType()
        object Poster : CropType()
    }

}