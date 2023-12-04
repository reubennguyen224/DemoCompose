package com.demoapp.democompose.ui.screens.createtask

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.theme.titleColor

@Composable
fun CreateTask() {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back")
            Text(
                text = "Add Task",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = titleColor,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    CreateTask()
}