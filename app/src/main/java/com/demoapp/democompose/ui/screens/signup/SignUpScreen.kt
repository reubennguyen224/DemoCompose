package com.demoapp.democompose.ui.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.screens.common.CustomTextField
import com.demoapp.democompose.ui.screens.common.NormalButton
import com.demoapp.democompose.ui.screens.common.PasswordTextField
import com.demoapp.democompose.ui.theme.primaryColor
import com.demoapp.democompose.ui.theme.secondaryText

@Composable
fun SignUpScreen(
    onNavigateToLogin: () -> Unit,
    onSignUpSuccess: () -> Unit,
    signUpViewModel: SignUpViewModel = viewModel()
) {
    val uiState by remember {
        signUpViewModel.uiState
    }

    if (uiState.isSignUpSuccess) {
        LaunchedEffect(key1 = true) {
            onSignUpSuccess.invoke()
        }
    } else {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .imePadding()
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Text(
                text = "Sign Up",
                color = primaryColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 36.sp,
                modifier = Modifier.padding(start = 36.dp)
            )

            CustomTextField(
                text = uiState.emailOrUid, onValueChange = { emailInputString ->
                    signUpViewModel.onEmailChanged(emailInputString)
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp, top = 70.dp),
                label = "Username"
            )

            CustomTextField(
                text = uiState.emailOrUid, onValueChange = { emailInputString ->
                    signUpViewModel.onEmailIDChanged(emailInputString)
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp, top = 32.dp),
                label = "Username",
                icon = painterResource(id = R.drawable.lock)
            )

            PasswordTextField(
                value = uiState.password,
                onValueChange = { passwordString ->
                    signUpViewModel.onPasswordChanged(passwordString)
                },
                isError = false,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 35.dp, end = 35.dp, top = 32.dp),
                label = "Password",
                isShowTrailingIcon = false
            )

            NormalButton(
                text = "Create", onClick = {
                    signUpViewModel.onSubmit()
                }, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 35.dp, end = 35.dp, top = 55.dp)
            )

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 55.dp),
            ) {
                Divider(
                    modifier = Modifier
                        .width(121.dp)
                        .align(Alignment.CenterVertically)
                        .padding(end = 22.dp)
                )
                Text(
                    text = "or with",

                    fontSize = 12.sp,
                    color = secondaryText,
                )
                Divider(
                    modifier = Modifier
                        .width(121.dp)
                        .align(Alignment.CenterVertically)
                        .padding(start = 22.dp)
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 30.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_circle_google),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { }
                        .padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_circle_facebook),
                    contentDescription = "",
                    modifier = Modifier
                        .clickable { }
                        .padding(start = 8.dp)
                )
            }

            Text(text = buildAnnotatedString {
                append("Have any account? ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Sign In")
                }
            }, modifier = Modifier
                .clickable { onNavigateToLogin.invoke() }
                .align(Alignment.CenterHorizontally)
                .padding(top = 90.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUpScreen(onNavigateToLogin = {}, onSignUpSuccess = {})
}