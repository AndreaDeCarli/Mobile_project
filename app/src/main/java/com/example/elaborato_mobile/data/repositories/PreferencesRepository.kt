package com.example.elaborato_mobile.data.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.map

class PreferencesRepository (
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val PROFILE_ACTIVE = longPreferencesKey("profile_active")
    }

    val profileActive = dataStore.data.map { it[PROFILE_ACTIVE] ?: -1 }

    suspend fun setProfileActive(profileId: Long) = dataStore.edit { it[PROFILE_ACTIVE] = profileId }
}