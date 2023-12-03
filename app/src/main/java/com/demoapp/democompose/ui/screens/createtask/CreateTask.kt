package com.demoapp.democompose.ui.screens.createtask

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.demoapp.democompose.R

@Composable
fun CreateTask(){
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back")
            Text(text = "Add Task")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    CreateTask()
}