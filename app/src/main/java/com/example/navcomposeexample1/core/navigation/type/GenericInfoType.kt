package com.example.navcomposeexample1.core.navigation.type

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T: Parcelable> createNavType():NavType<T>{
    return object : NavType<T>(isNullableAllowed = true){

        override fun get(bundle: Bundle, key: String): T? {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key, T::class.java)
            } else {
                bundle.getParcelable(key)
            }
        }
        // parse the SettingsInfo object to become into json object
        override fun serializeAsValue(value: T): String {
            return Uri.encode(Json.encodeToString(value))
        }
        // parse the json object to SettingsInfo
        override fun parseValue(value: String): T {
            return Json.decodeFromString<T>(value)
        }
        // describe how to become and object to be send or read
        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putParcelable(key, value)// remember you has a parcelable object
        }

    }
}