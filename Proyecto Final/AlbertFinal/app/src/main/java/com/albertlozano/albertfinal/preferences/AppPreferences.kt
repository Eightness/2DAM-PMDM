/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.albertlozano.albertfinal.model.User
import kotlinx.coroutines.flow.map

/**
 * AppPreferences Class
 *
 * @property context
 */
class AppPreferences(private val context: Context) {
    companion object {
        val USER_NAME = stringPreferencesKey("USER_NAME")

        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")
    }

    suspend fun saveUser(userPreferences: User) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = userPreferences.userName
        }
    }

    fun loadUser() = context.dataStore.data.map { preferences ->
        User (
            userName = preferences[USER_NAME] ?: "",
        )
    }

    suspend fun deleteUserPreferences() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_NAME)
        }
    }

    fun isDataStored() = context.dataStore.data.map { preferences ->
        preferences.contains(USER_NAME)
    }
}