package com.kmp.movie.local

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.kmp.movie.data.local.LocalDataSource
import com.kmp.movie.local.LocalConstants.IS_LIGHT_THEME_KEY
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LocalDataSourceImpl(): LocalDataSource {

    private val dataStore = createDataStore()

    companion object {
        private val IS_LIGHT_THEME = booleanPreferencesKey(IS_LIGHT_THEME_KEY)
    }

    override suspend fun saveIsLightTheme(isLightTheme: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_LIGHT_THEME] = isLightTheme
        }
    }

    override suspend fun getIsLightTheme(): Boolean {
        return dataStore.data
            .catch { exception ->
                if (exception is Exception) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                val isLightTheme = preferences[IS_LIGHT_THEME] == true
                isLightTheme
            }
            .first()
    }


}