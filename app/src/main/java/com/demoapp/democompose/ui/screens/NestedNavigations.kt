package com.demoapp.democompose.ui.screens

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.demoapp.democompose.ui.screens.home.HomeScreen
import com.demoapp.democompose.ui.screens.login.LoginScreen
import com.demoapp.democompose.ui.screens.signup.SignUpScreen

fun NavGraphBuilder.authenGraph(navController: NavController) {
    navigation(
        route = NavigationRoutes.Authenticate.NavigationRoute.route,
        startDestination = NavigationRoutes.Authenticate.Login.route
    ) {
        composable(NavigationRoutes.Authenticate.Splash.route) {
            Greeting(onNavigateToLoginScreen = {
                navController.navigate(route = NavigationRoutes.Authenticate.Login.route)
            }, onNavigateToSignUpScreen = {

            })
        }
        composable(route = NavigationRoutes.Authenticate.Login.route) {
            LoginScreen(onNavigateToSignUp = {
                navController.navigate(route = NavigationRoutes.Authenticate.SignUp.route)
            })
        }

        composable(route = NavigationRoutes.Authenticate.SignUp.route) {
            SignUpScreen(onNavigateToLogin = {
                navController.navigate(route = NavigationRoutes.Authenticate.Login.route)
            }, onSignUpSuccess = {
                navController.navigate(route = NavigationRoutes.Authenticate.Login.route)
            })
        }
    }
}