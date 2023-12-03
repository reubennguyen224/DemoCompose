package com.demoapp.democompose.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.demoapp.democompose.ui.screens.login.state.LoginState
import com.demoapp.democompose.ui.screens.login.state.LoginUIEvent

class LoginViewModel: ViewModel() {
    var uiState = mutableStateOf(LoginState())
        private set

    fun onUiEvent(loginUIEvent: LoginUIEvent) {
        when (loginUIEvent) {
            is LoginUIEvent.EmailOrUidChanged -> {
                uiState.value = uiState.value.copy(
                    emailOrUid = loginUIEvent.input,
                )
            }
            is LoginUIEvent.PasswordChanged -> {
                uiState.value = uiState.value.copy(
                    password = loginUIEvent.input
                )
            }
            LoginUIEvent.Submit -> {
                if (isValidate()) {
                    uiState.value = uiState.value.copy(isLoginSuccess = true)
                }
            }
        }
    }

    private fun isValidate(): Boolean {
        val emailStr = uiState.value.emailOrUid.trim()
        val password = uiState.value.password
        return when {
            emailStr.isEmpty() -> false
            password.isEmpty() -> false
            else -> true
        }
    }
}