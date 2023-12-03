package com.demoapp.democompose.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.screens.common.TaskCard

@Preview(showBackground = true)
@Composable
fun preview() {
    MyTask()
}

@Composable
fun MyTask(

) {
    Row {
        Column {
            TaskCard(onClick = {}, label = "Completed", isWhiteTextColor = false)
            TaskCard(
                onClick = {},
                label = "Canceled",
                icon = painterResource(id = R.drawable.ic_cancel),
                background = painterResource(
                    id = R.drawable.bg_cancel
                ),
                height = 116.dp,
                needSpace = true
            )
        }

        Column {
            TaskCard(
                onClick = {},
                label = "Pending",
                icon = painterResource(id = R.drawable.ic_clock),
                background = painterResource(
                    id = R.drawable.bg_pending
                ),
                height = 116.dp,
                needSpace = true
            )
            TaskCard(
                onClick = {},
                label = "On Going",
                icon = painterResource(id = R.drawable.ic_folder),
                background = painterResource(
                    id = R.drawable.bg_on_going
                ),
                isWhiteTextColor = false
            )
        }
    }
}