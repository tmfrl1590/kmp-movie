package com.kmp.movie.presentation

import android.content.Context
import android.content.pm.PackageManager

object ContextProvider {
    lateinit var applicationContext: Context
        private set

    fun initialize(context: Context) {
        applicationContext = context.applicationContext
    }
}

actual fun getAppVersion(): String {
    return try {
        val context = ContextProvider.applicationContext
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        packageInfo.versionName ?: "Unknown"
    } catch (e: PackageManager.NameNotFoundException) {
        "Unknown"
    }
}