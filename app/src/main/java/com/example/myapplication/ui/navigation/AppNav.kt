package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.CreateAccountScreen
import com.example.myapplication.ui.screen.LoginScreen
import com.example.myapplication.ui.screen.SetupScreen1
import com.example.myapplication.ui.screen.SetupScreen2
import com.example.myapplication.ui.screen.SetupScreen3
import com.example.myapplication.ui.screen.SetupScreen4
import com.example.myapplication.ui.screen.WelcomeScreen

object Routes {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val CREATE = "create"
    const val SETUP1 = "setup1"
    const val SETUP2 = "setup2"
    const val SETUP3 = "setup3"
    const val SETUP4 = "setup4"
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
                onCreateAccount = { _, _, _ ->
                    nav.navigate(Routes.SETUP1)
                },
                onGoToLogin = { nav.navigate(Routes.LOGIN) }
            )
        }

        composable(Routes.SETUP1) {
            SetupScreen1(
                onBack = { nav.popBackStack() },
                onNext = { nav.navigate(Routes.SETUP2) }
            )
        }

        composable(Routes.SETUP2) {
            SetupScreen2(
                onBack = { nav.popBackStack() },
                onNext = { nav.navigate(Routes.SETUP3) }
            )
        }

        composable(Routes.SETUP3) {
            SetupScreen3(
                onBack = { nav.popBackStack() },
                onNext = { nav.navigate(Routes.SETUP4) }
            )
        }

        composable(Routes.SETUP4) {
            SetupScreen4(
                onBack = { nav.popBackStack() },
                onFinish = {
                    nav.navigate(Routes.WELCOME) {
                        popUpTo(Routes.WELCOME) { inclusive = true }
                    }
                }
            )
        }
    }
}