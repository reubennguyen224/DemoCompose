package com.demoapp.democompose.ui.screens.signup.state

data class SignUpState(
    val emailOrUid: String = "",
    val password: String = "",
    val isSignUpSuccess: Boolean = false,
    val errorState: String = ""
)

sealed class SignUpUIEvent{
    data class OnEmailChanged(val email: String): SignUpUIEvent()
    data class OnPasswordChanged(val password: String): SignUpUIEvent()
    data class OnConfirmPasswordChanged(val password: String): SignUpUIEvent()
    object Submit: SignUpUIEvent()
}