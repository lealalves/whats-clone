package com.fatec.whatsclone.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fatec.whatsclone.ui.screens.ChatScreen
import com.fatec.whatsclone.ui.screens.UserInformationScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ChatScreen.route
    ) {
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController)
        }
        composable(
            Screen.Information.routeWithArg,
            arguments = Screen.Information.arguments
        ) { backStackEntry ->
            val userInfo = backStackEntry.arguments?.getString(
                Screen.Information.NAME_INFO
            ) ?: ""
            UserInformationScreen(userInformation = userInfo, navController = navController)
        }
    }
}