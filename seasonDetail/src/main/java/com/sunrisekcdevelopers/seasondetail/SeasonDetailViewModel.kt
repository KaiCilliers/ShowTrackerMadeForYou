package com.sunrisekcdevelopers.seasondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeasonDetailViewModel : ViewModel(), SeasonDetailViewModelContract {
    override val someData = MutableLiveData<Int>()

    init {
        foo()
    }

    private fun foo() {
        someData.value = 0
    }
}