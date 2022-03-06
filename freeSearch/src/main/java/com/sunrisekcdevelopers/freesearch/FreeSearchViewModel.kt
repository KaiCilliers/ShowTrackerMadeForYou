package com.sunrisekcdevelopers.freesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FreeSearchViewModel : ViewModel(), FreeSearchViewModelContract {
    override val someData = MutableLiveData<Int>()

    init {
        foo()
    }

    private fun foo() {
        someData.value = 0
    }
}