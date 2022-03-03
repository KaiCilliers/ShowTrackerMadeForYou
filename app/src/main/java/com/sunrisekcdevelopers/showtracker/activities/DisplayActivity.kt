package com.sunrisekcdevelopers.showtracker.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sunrisekcdevelopers.logging.timber
import com.sunrisekcdevelopers.showtracker.databinding.DisplayActivityBinding
import com.sunrisekcdevelopers.ui_components.components.StBanner
import com.sunrisekcdevelopers.ui_components.components.StPoster
import com.sunrisekcdevelopers.ui_components.components.StProgressBar
import com.sunrisekcdevelopers.ui_components.components.st_setting_menu_item.StSettingMenuItem
import com.sunrisekcdevelopers.ui_components.components.st_media_core_details.MediaQuickSummary.Movie
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding
import kotlinx.coroutines.*
import timber.log.Timber

class DisplayActivity : AppCompatActivity() {
    private val log by timber()
    private val binding by viewBinding(DisplayActivityBinding::inflate)

    private var count = 0.0

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
        binding.pbar.setOnCheckClickListener {
            when (it) {
                StProgressBar.CheckMarkState.Off -> {
                    binding.pbar.setData(0.0, 100.0)
                }
                StProgressBar.CheckMarkState.On -> {
                    binding.pbar.setData(100.0, 100.0)
                }
            }
        }
        MainScope().launch {
            while (true) {
                binding.pbar.loop()
            }
        }
        binding.wrap.setTitle("Genres")
        binding.wrap.setTags(
            listOf("English", "Portuguese", "Latin", "German", "Afrikaans", "Swedish", "Mandarin", "Japanese")
        )

        MainScope().launch {
            while (true) {
                movePosterIcon()
            }
        }
        binding.posterr.setImage("https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e")

        binding.banner.setMessage("S04E04 in 8 days")
        binding.banner.setIcon(StBanner.BannerIcon.Share)

        binding.seasonProgress.setTitle("aldkjasdjakldasdjalkd")
        binding.seasonProgress.setMaxValue(55.0)
        binding.seasonProgress.setProgress(44.0)
        binding.seasonProgress.setPosterImage("https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e")
        binding.seasonProgress.setBannerMessage("banner")
        binding.seasonProgress.showBanner()

        binding.watchItem.setSeasonTitle("Friends")
        binding.watchItem.setEpisodeTitle("S04E12 · Rachel eats frog legs")
        binding.watchItem.setSeasonData(12, 48)
        binding.watchItem.setSeasonPoster("https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e")
        binding.watchItem.setOnActionIconClickListener {
            binding.watchItem.setSeasonData(
                binding.watchItem.getCurrentProgress() + 1,
                48
            )
        }

        binding.profile.setProfileImage("https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e")

        binding.numberToggle.setNumber(9)

        binding.seasonEpi.setNumber(8)
        binding.seasonEpi.setImage("https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=67773a9d419786091c958b2ad08eae5e")

        binding.settingBase.apply {
            showLeftIcon()
            showSwitchComponent()
            setSwitchState(StSettingMenuItem.SwitchState.On)
            setTitle("Subgroup")
            setCaption("Current Selection")
        }

        binding.setttingSubGroup.setOnClickNavAction {
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        }

        binding.settingSwitch.setSettingName("Setting Toggle")

        binding.collapseList.setTitle("Watched Movies")

        binding.searchbarmain.setOnQueryTextChangeListener { text, start, before, count ->
            println("text = $text")
            println("start = $start")
            println("count = $count")
            println("before = $before")
        }
    }

    suspend fun movePosterIcon() {
        delay(2000)
        binding.posterr.setIconPlacement(StPoster.IconPlacement.TopRight)
        binding.posterr.setCropType(StPoster.CropType.Circle)

        delay(2000)
        binding.posterr.setIconPlacement(StPoster.IconPlacement.TopLeft)
        binding.posterr.setCropType(StPoster.CropType.Poster)

        delay(2000)
        binding.posterr.setIconPlacement(StPoster.IconPlacement.BottomLeft)
        binding.posterr.setCropType(StPoster.CropType.Circle)

        delay(2000)
        binding.posterr.setIconPlacement(StPoster.IconPlacement.BottomRight)
        binding.posterr.setCropType(StPoster.CropType.Poster)
    }
}