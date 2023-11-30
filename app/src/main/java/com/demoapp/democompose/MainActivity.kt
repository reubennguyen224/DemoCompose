package com.demoapp.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.ui.NoBackgroundButton
import com.demoapp.democompose.ui.NormalButton
import com.demoapp.democompose.ui.theme.DemoComposeTheme
import com.demoapp.democompose.ui.theme.pink
import com.demoapp.democompose.ui.theme.primaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoComposeTheme {
                // A surface container using the 'background' color from the theme
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.img_logo),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(12.dp)
            )
            Spacer(modifier = Modifier.padding(23.dp))
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
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.padding(15.dp))
            NormalButton(text = "Login", onClick = {}, )
            NoBackgroundButton(text = "Sign Up", onClick = {})
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DemoComposeTheme {
        Greeting()
    }
}