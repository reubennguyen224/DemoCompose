package com.demoapp.democompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.screens.common.NoBackgroundButton
import com.demoapp.democompose.ui.screens.common.NormalButton
import com.demoapp.democompose.ui.theme.pink
import com.demoapp.democompose.ui.theme.primaryColor

@Composable
fun Greeting(
    onNavigateToLoginScreen: () -> Unit,
    onNavigateToSignUpScreen: () -> Unit
) {
    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(start = 42.dp, end = 42.dp).height(290.dp).width(290.dp)
            )
            Spacer(modifier = Modifier.padding(37.dp))
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = primaryColor)){
                    append("Dailoz")
                }
                withStyle(style = SpanStyle(color = pink)){
                    append(".")
                }
            }, fontSize = 32.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))
            Text(text = "Plan what you will do to be more organized for today, \ntomorrow and beyond",
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp))
            Spacer(modifier = Modifier.padding(32.dp))
            NormalButton(text = "Login", onClick = onNavigateToLoginScreen, modifier = Modifier.padding(start = 35.dp, end = 35.dp))
            NoBackgroundButton(text = "Sign Up", onClick = onNavigateToSignUpScreen, modifier = Modifier.padding(start = 35.dp, end = 35.dp))
        }
    }
}