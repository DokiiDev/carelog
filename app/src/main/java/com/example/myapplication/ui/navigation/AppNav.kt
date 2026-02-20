package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.CreateAccountScreen
import com.example.myapplication.ui.screen.LoginScreen
import com.example.myapplication.ui.screen.WelcomeScreen

object Routes {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val CREATE = "create"
}

@Composable
fun AppNav() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Routes.WELCOME) {
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onLogin = { nav.navigate(Routes.LOGIN) },
                onCreateAccount = { nav.navigate(Routes.CREATE) }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onBack = { nav.popBackStack() },
                onLogin = { _, _ -> },
                onCreateAccount = { nav.navigate(Routes.CREATE) }
            )
        }

        composable(Routes.CREATE) {
            CreateAccountScreen(
                onBack = { nav.popBackStack() },
                onCreateAccount = { _, _, _ -> },
                onGoToLogin = {
                    nav.navigate(Routes.LOGIN) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}