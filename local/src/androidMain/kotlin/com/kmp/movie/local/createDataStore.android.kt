package com.kmp.movie.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.runBlocking

actual fun createDataStore(): DataStore<Preferences> {
    return runBlocking {
        getDataStore(producePath = {
            ContextUtils.dataStoreApplicationContext!!.filesDir.resolve(
                dataStoreFileName
            ).absolutePath
        })
    }
}

object ContextUtils {

    var dataStoreApplicationContext: Context? = null

    fun setContext(context: Context) {
        dataStoreApplicationContext = context.applicationContext
    }
}