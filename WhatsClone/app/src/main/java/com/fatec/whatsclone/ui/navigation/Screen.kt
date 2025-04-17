package com.fatec.whatsclone.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    object ChatScreen : Screen(route="chat_screen")
    object EditInformation : Screen(route = "edit_information") {
        const val USER_INFO = "name;email"
        val routeWithArg = "$route/${USER_INFO}"
        val argument = listOf(
            navArgument(USER_INFO) {
                type = NavType.StringType
            }
        )

        fun createRoute(userInfo: String) = "$route/$userInfo"
    }
    object Information : Screen(route = "information") {
        const val NAME_INFO = "name"
        val routeWithArg = "$route/${NAME_INFO}"
        val arguments = listOf(
            navArgument(NAME_INFO) {
                type = NavType.StringType
            }
        )
        fun createRoute(name: String) = "$route/$name"
    }
}