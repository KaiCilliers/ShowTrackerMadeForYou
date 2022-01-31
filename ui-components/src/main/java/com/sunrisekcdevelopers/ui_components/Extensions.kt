package com.sunrisekcdevelopers.ui_components

import android.content.res.Resources
import android.content.res.TypedArray
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View

/**
 * [String] extensions
 */
inline fun String.valid(
    crossinline yes: (String) -> Unit = {},
    crossinline no: (String) -> Unit = {}
) {
    if (isNotEmpty()) yes(this) else no(this)
}

/**
 * [Float] extensions
 */
inline fun Float.valid(
    crossinline yes: (Float) -> Unit = {},
    crossinline no: (Float) -> Unit = {}
) {
    if (this != Float.MIN_VALUE) yes(this) else no(this)
}

/**
 * [TypedArray] extensions
 */
inline fun TypedArray.withRecycle(crossinline action: (TypedArray) -> Unit) {
    action(this)
    recycle()
}

/**
 * [View] extensions
 */
fun View.gone() { if(visibility != View.GONE) this.visibility = View.GONE }
fun View.visible() { if(visibility != View.VISIBLE) this.visibility = View.VISIBLE }
fun View.invisible() { if(visibility != View.INVISIBLE) this.visibility = View.INVISIBLE }
fun View.enabled() { isEnabled = true }
fun View.disabled() { isEnabled = false }

/**
 * [Number] extensions
 */
val Number.dp get() = (toFloat() * (Resources.getSystem().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
val Number.px get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, toFloat(), Resources.getSystem().displayMetrics)