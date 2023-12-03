package com.demoapp.democompose.ui.screens

sealed class NavigationRoutes {
    sealed class Authenticate(val route: String): NavigationRoutes() {
        object Login : Authenticate(route = "login")
        object SignUp : Authenticate(route = "signUp")
        object NavigationRoute : Authenticate(route = "authenticate")
        object Splash : Authenticate(route = "splash")
    }

    sealed class LoginSuccess(val route: String): NavigationRoutes() {
        object NavigationRoute : LoginSuccess(route = "loginSuccess")
        object Dashboard : LoginSuccess(route = "dashboard")
    }
}