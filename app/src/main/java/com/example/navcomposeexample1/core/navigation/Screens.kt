package com.example.navcomposeexample1.core.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val name:String)

@Serializable
data class Settings(val settingsInfo:SettingsInfo)

/*
This object need to be Parcelable hence you have to add a new dependency
 */
@Parcelize
@Serializable
data class SettingsInfo(val name: String, val id:Int, val darkMode:Boolean, val subscribe:Boolean):Parcelable