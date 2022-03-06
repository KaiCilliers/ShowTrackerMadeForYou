package com.sunrisekcdevelopers.persondetail

import androidx.lifecycle.LiveData

interface PersonDetailViewModelContract {
    val someData: LiveData<PersonDetailUiModel>
}
