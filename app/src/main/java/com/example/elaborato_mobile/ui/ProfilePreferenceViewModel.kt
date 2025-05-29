package com.example.elaborato_mobile.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elaborato_mobile.data.repositories.PreferencesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

data class ProfilePreferencesState(val profile: Long)

class ProfilePreferenceViewModel(
    private val repository: PreferencesRepository
) : ViewModel() {
    var state by mutableStateOf(ProfilePreferencesState(-1))
        private set

    fun setUsername(profile: Long) {
        state = ProfilePreferencesState(profile)
        viewModelScope.launch {
            repository.setProfileActive(profile)
        }
    }

    init {
        viewModelScope.launch {
            state = ProfilePreferencesState(repository.profileActive.first())
        }
    }
}
