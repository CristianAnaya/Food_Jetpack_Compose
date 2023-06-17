package com.cranaya.data.auth.repository.dataSourceImpl

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cranaya.data.auth.mapper.toAuth
import com.cranaya.data.auth.mapper.toAuthDto
import com.cranaya.data.auth.model.dto.AuthDto
import com.cranaya.data.auth.repository.dataSource.AuthTemporalDataSource
import com.cranaya.domain.auth.model.Auth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthTemporalDataSourceImpl constructor(
    private val dataStore: DataStore<Preferences>
): AuthTemporalDataSource {

    companion object {
        private const val AUTH_KEY = "AUTH_KEY"
    }

    override suspend fun saveSession(auth: Auth) {
        val authDto = auth.toAuthDto()
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = authDto.toJson()
        }
    }

    override fun getSessionData(): Flow<Auth> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null) {
                Log.d("AuthTemporalDataSourceImpl", "getSessionData: ${AuthDto.fromJson(pref[dataStoreKey] ?: "").toAuth()}")
                AuthDto.fromJson(pref[dataStoreKey] ?: "").toAuth()
            } else {
                AuthDto().toAuth()
            }
        }
    }

    override suspend fun logout() {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref.remove(dataStoreKey)
        }
    }

}