package com.sunrisekcdevelopers.refinedsearch.multi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RefinedSearchMultiViewModel : ViewModel(), RefinedSearchMultiViewModelContract {
    override val someData = MutableLiveData<Int>()

    init {
        foo()
    }

    private fun foo() {
        someData.value = 0
    }
}