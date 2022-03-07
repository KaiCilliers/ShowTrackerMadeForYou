package com.sunrisekcdevelopers.refinedsearch.single

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RefinedSearchSingleViewModel : ViewModel(), RefinedSearchSingleViewModelContract {
    override val someData = MutableLiveData<Int>()

    init {
        foo()
    }

    private fun foo() {
        someData.value = 0
    }
}