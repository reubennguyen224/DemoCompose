package com.demoapp.democompose.ui.screens.task

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.screens.common.SmallItemTask
import com.demoapp.democompose.ui.screens.home.state.ListTask
import com.demoapp.democompose.ui.screens.home.state.Task
import com.demoapp.democompose.ui.theme.primaryColor
import com.demoapp.democompose.ui.theme.subTitleText
import com.demoapp.democompose.ui.theme.textColor
import com.demoapp.democompose.ui.theme.tintSearch
import com.demoapp.democompose.ui.theme.titleColor
import com.demoapp.democompose.ui.theme.trans
import com.demoapp.democompose.ui.theme.white

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTaskScreen() {
    TaskScreen()
}

@Composable
fun TaskScreen(

) {
    val dayList = DayList()
    val dumpListTak: List<TaskList> = listOf(
        TaskList(), TaskList(
            listTask = ListTask(
                listOf(
                    Task(title = "test", timeBegin = "7:00", timeEnd = "8:00"),
                    Task(title = "test", timeBegin = "7:00", timeEnd = "8:00")
                )
            )
        ), TaskList(), TaskList(), TaskList(
            listTask = ListTask(
                listOf(
                    Task(title = "test", timeBegin = "7:00", timeEnd = "8:00"),
                    Task(title = "test", timeBegin = "7:00", timeEnd = "8:00")
                )
            )
        )
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp, bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBox(
            value = "", onValueChange = {}, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Task",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = titleColor
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "icon",
                    colorFilter = ColorFilter.tint(subTitleText)
                )
                Text(text = "August 2023", color = subTitleText, fontSize = 12.sp)
            }
        }
        LazyRow(modifier = Modifier.padding(top = 16.dp), contentPadding = PaddingValues(2.dp)) {
            items(dayList.list) {
                DayItem(day = it.day, dayNumber = it.dayNumber)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Today",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = titleColor
            )
            Text(
                text = "09 h 45 min",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 12.sp
            )
        }
        LazyColumn(modifier = Modifier.padding(24.dp)) {
            if (dumpListTak.isEmpty()){
                item {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                        Image(painter = painterResource(id = R.drawable.ic_blank_task), contentDescription = "blank")
                        Text(
                            text = "You don’t have any schedule today. \nTap the plus button to create new to-do.",
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    }
                }
            } else
            items(dumpListTak) {
                Divider(thickness = 1.dp, modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 24.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = it.time,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 11.dp)
                    )
                    LazyRow(modifier = Modifier.padding(start = 20.dp)) {
                        when (it.listTask.list.size) {
                            0 -> {
                                item {
                                    Text(text = buildAnnotatedString {
                                        append("You don’t have any schedule  or  ")
                                        withStyle(style = SpanStyle(color = titleColor)) {
                                            append("+ Add")
                                        }
                                    })
                                }
                            }

                            else -> {
                                items(it.listTask.list) {
                                    SmallItemTask(task = it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DayItem(
    day: String,
    isSelected: Boolean = false,
    dayNumber: String
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(71.dp)
            .width(41.dp)
            .clickable { },
        colors = CardDefaults.cardColors(if (isSelected) primaryColor else trans)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = day, color = if (isSelected) white else titleColor, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 12.dp, start = 12.dp)
            )
            Text(
                text = dayNumber, color = if (isSelected) white else titleColor, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 4.dp, start = 12.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    modifier: Modifier = Modifier, value: String,
    onValueChange: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Search,
    keyboardType: KeyboardType = KeyboardType.Text,
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        placeholder = { Text(text = "Search for task") },
        textStyle = TextStyle(color = textColor),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = trans,
            focusedIndicatorColor = trans
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "icon",
                tint = tintSearch
            )
        },
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_square),
                    contentDescription = "icon",
                    tint = tintSearch
                )
            }
        }
    )
}