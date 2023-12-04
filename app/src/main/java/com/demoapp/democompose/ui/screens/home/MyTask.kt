package com.demoapp.democompose.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    numberComplete: Int = 0,
    numberCancel: Int = 0,
    numberPending: Int = 0,
    numberOngoing: Int = 0,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Column {
            TaskCard(onClick = {}, label = "Completed", isWhiteTextColor = false, numberTask = numberComplete)
            TaskCard(
                onClick = {},
                label = "Canceled",
                icon = painterResource(id = R.drawable.ic_cancel),
                background = painterResource(
                    id = R.drawable.bg_cancel
                ),
                height = 116.dp,
                needSpace = true,
                numberTask = numberCancel
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
                needSpace = true,
                numberTask = numberPending
            )
            TaskCard(
                onClick = {},
                label = "On Going",
                icon = painterResource(id = R.drawable.ic_folder),
                background = painterResource(
                    id = R.drawable.bg_on_going
                ),
                isWhiteTextColor = false,
                numberTask = numberOngoing
            )
        }
    }
}