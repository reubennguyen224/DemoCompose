package com.demoapp.democompose.ui.screens.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.demoapp.democompose.ui.screens.signup.state.SignUpState

class SignUpViewModel: ViewModel() {
    val uiState = mutableStateOf(SignUpState())

    fun onEmailChanged(email: String){

    }

    fun onPasswordChanged(password: String){

    }

    fun onEmailIDChanged(emailId: String) {

    }

    fun onSubmit(){

    }
}