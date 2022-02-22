package com.sunrisekcdevelopers.showtracker.primary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sunrisekcdevelopers.showtracker.R
import com.sunrisekcdevelopers.showtracker.databinding.MyListTvShowFragmentBinding
import com.sunrisekcdevelopers.ui_components.viewbinding.viewBinding

class MyListTVShowFragment : Fragment(R.layout.my_list_tv_show_fragment) {
    private val binding: MyListTvShowFragmentBinding by viewBinding(MyListTvShowFragmentBinding::bind)
}