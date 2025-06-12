package com.example.navcomposeexample1.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.navcomposeexample1.DetailScreen
import com.example.navcomposeexample1.HomeScreen
import com.example.navcomposeexample1.LoginScreen
import com.example.navcomposeexample1.SettingsScreen
import com.example.navcomposeexample1.core.navigation.type.createNavType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login ){
        composable<Login>{
            LoginScreen{ navController.navigate(Home)}
        }

        composable<Home> {
            HomeScreen{ messageToDetail -> navController.navigate(Detail(name = messageToDetail)) }
        }

        composable<Detail> { backStackEntry ->
            val detail:Detail = backStackEntry.toRoute<Detail>()
            DetailScreen(
                name = detail.name,
                navigateBack = {
                    /* back one in nav stack */
                      //  navController.popBackStack()
                    /* back one in your app flow e.g when you open a pdf */
                      //  navController.navigateUp()
                    /*
                    using this you will back till the first screen
                    then you use popUpTo, to delete the stack such that you can not back in the stack
                    finally you also can use inclusive set to false -> if the user try to back in the first
                    screen it won't. If true user close the app
                    */
                    navController.navigate(Login){
                        popUpTo<Login>(){inclusive = false}
                    }
                },
                navigateToSettings = { navController.navigate(Settings(it)) }
            )
        }

        //composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to settingsInfoType)) { backStackEntry ->
        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to createNavType<SettingsInfo>())) { backStackEntry ->
            val settings: Settings = backStackEntry.toRoute()
            SettingsScreen(settings.settingsInfo)
        }
    }
}