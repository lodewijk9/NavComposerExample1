package com.example.navcomposeexample1.core.navigation.type

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.example.navcomposeexample1.core.navigation.SettingsInfo
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val settingsInfoType = object : NavType<SettingsInfo>(isNullableAllowed = true) {
    override fun get(bundle: Bundle, key: String): SettingsInfo? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, SettingsInfo::class.java)
        } else {
            bundle.getParcelable(key)
        }
    }
    // parse the SettingsInfo object to become into json object
    override fun serializeAsValue(value: SettingsInfo): String {
        return Uri.encode(Json.encodeToString(value))
    }
    // parse the json object to SettingsInfo
    override fun parseValue(value: String): SettingsInfo {
        return Json.decodeFromString<SettingsInfo>(value)
    }
    // describe how to become and object to be send or read
    override fun put(bundle: Bundle, key: String, value: SettingsInfo) {
        bundle.putParcelable(key, value)// remember you has a parcelable object
    }

}