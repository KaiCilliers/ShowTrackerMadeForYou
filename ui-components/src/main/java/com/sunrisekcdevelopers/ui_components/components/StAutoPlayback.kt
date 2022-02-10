package com.sunrisekcdevelopers.ui_components.components

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.webkit.*
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import com.sunrisekcdevelopers.ui_components.databinding.StAutoPlaybackBinding
import com.sunrisekcdevelopers.ui_components.visible


// https://exoplayer.dev/hello-world.html
// besides this sketchy vid https://www.youtube.com/watch?v=8MLa-Lh8lkU
//  i cant find resources to play youtube links in ExoPlayer
//  other apps seem to use a Webview
// https://www.tutorialspoint.com/how-to-play-youtube-videos-in-my-android-application-using-kotlin
// i have a problem, idk when an embedded YT vid is unplayable or fails to load
//  so how about i have a horizontal list at top of screen which has all trailers
//  if first one fails then there is other easily accessible for user
//  this can be RC list with snap in place to so single list item fills entire parent width
//  Or a type of viewpager?
//  Just prevent multiple vids playing at same time
class StAutoPlayback @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: StAutoPlaybackBinding by lazy(LazyThreadSafetyMode.NONE) {
        StAutoPlaybackBinding.inflate(LayoutInflater.from(context), this)
    }


    init {
        @SuppressLint("SetJavaScriptEnabled")
        binding.stAutoPlaybackWebview.settings.javaScriptEnabled = true
        binding.stAutoPlaybackWebview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                println("kai page loading: $newProgress")
                super.onProgressChanged(view, newProgress)
            }
        }
        // failing key kwZx0-agqb0
        // working key HIqjl8njVYw
        binding.stAutoPlaybackWebview.loadData(
            SourceBuilder("HIqjl8njVYw").get(),
            "text/html",
            "utf-8"
        )
        binding.stAutoPlaybackWebview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                println("kai Your WebView is Loaded....")
                super.onPageFinished(view, url)
                binding.stAutoPlaybackWebview.apply {
                    alpha = 0f
                    visible()
                    val anim = ObjectAnimator.ofFloat(this, "alpha", 1f)
                    anim.duration = 500
                    anim.start()
                }
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                println("eceived error $error")
                super.onReceivedError(view, request, error)
            }
        }
    }

}

class SourceBuilder(val key: String) {
    companion object {
        const val prefix = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"
        const val suffix = "\" frameborder=\"0\" allowfullscreen></iframe>"
    }
    fun get(): String {
        return "$prefix$key$suffix"
    }
}