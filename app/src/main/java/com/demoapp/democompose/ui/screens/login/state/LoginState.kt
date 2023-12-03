package com.demoapp.democompose.ui.screens.login.state

data class LoginState(
    val emailOrUid: String = "",
    val password: String = "",
    val isLoginSuccess: Boolean = false,
    val errorState: String = ""
)

sealed class LoginUIEvent{
    data class EmailOrUidChanged( val input: String): LoginUIEvent()
    data class PasswordChanged(val input: String): LoginUIEvent()
    object Submit: LoginUIEvent()
}