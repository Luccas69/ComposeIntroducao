package com.example.composeintroducao.datastore

import android.content.Context;
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(SETTINGS)

class AppDataStore @Inject constructor(
    var dataStore: DataStore<Preferences>
) {
    suspend fun putBoolean(key: Preferences.Key<Boolean>, value: Boolean){
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    fun getBoolean(key: Preferences.Key<Boolean>): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[key] ?: false
        }
    }
}
