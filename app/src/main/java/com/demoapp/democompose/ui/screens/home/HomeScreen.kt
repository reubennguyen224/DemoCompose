package com.demoapp.democompose.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.screens.common.ItemTask
import com.demoapp.democompose.ui.screens.home.state.ListTask
import com.demoapp.democompose.ui.screens.home.state.Task
import com.demoapp.democompose.ui.screens.home.state.User
import com.demoapp.democompose.ui.theme.hintColor
import com.demoapp.democompose.ui.theme.subTextColor
import com.demoapp.democompose.ui.theme.titleColor
import com.demoapp.democompose.ui.theme.white

@Composable
fun HomeScreen() {
    val tempList = listOf(
        User(
            "Steve",
            completedTaskList = ListTask(listOf(Task(title = "test"))),
            pendingTaskList = ListTask(listOf(Task(title = "test"))),
            cancelTaskList = ListTask(listOf(Task(title = "test"))),
            onGoingTaskList = ListTask(listOf(Task(title = "test")))
        ),
        ListTask(
            listOf(
                Task(title = "test", timeBegin = "7:00", timeEnd = "8:00"),
                Task(title = "test", timeBegin = "7:00", timeEnd = "8:00")
            )
        )
    )
    LazyColumn(modifier = Modifier.padding(bottom = 100.dp)) {
        items(tempList) { item ->
            when (item) {
                is User -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 45.dp, start = 24.dp, end = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Hi, ${item.username}",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 28.sp,
                                color = titleColor
                            )
                            Text(
                                text = "Let’s make this day productive",
                                color = hintColor,
                                fontSize = 14.sp
                            )
                        }

                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            colors = CardDefaults.cardColors(white)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_dump_avatar),
                                contentDescription = "avatar"
                            )
                        }
                    }

                    Text(
                        text = "My Task",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        color = titleColor,
                        modifier = Modifier.padding(top = 32.dp, start = 24.dp, bottom = 8.dp)
                    )

                    MyTask(
                        numberComplete = item.completedTaskList.list.size,
                        numberCancel = item.cancelTaskList.list.size,
                        numberPending = item.pendingTaskList.list.size,
                        numberOngoing = item.onGoingTaskList.list.size,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                is ListTask -> {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp, end = 24.dp, top = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Today Task",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 24.sp,
                            color = titleColor,
                        )
                        Text(
                            text = "View all",
                            color = subTextColor,
                            fontSize = 12.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    item.list.forEach {
                        ItemTask(task = it, modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 10.dp).clickable {  })
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHome() {
    HomeScreen()
}