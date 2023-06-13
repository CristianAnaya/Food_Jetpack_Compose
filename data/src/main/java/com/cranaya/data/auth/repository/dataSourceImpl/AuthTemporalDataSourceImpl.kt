package com.cranaya.data.auth.repository.dataSourceImpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cranaya.data.auth.model.dto.AuthResponse
import com.cranaya.data.auth.repository.dataSource.AuthTemporalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthTemporalDataSourceImpl constructor(
    private val dataStore: DataStore<Preferences>
): AuthTemporalDataSource {

    companion object {
        private const val AUTH_KEY = "AUTH_KEY"
    }

    override suspend fun saveSession(authResponse: AuthResponse) {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    override fun getSessionData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            AuthResponse.fromJson(pref[dataStoreKey] ?: "")
        }
    }

}