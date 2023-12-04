package com.demoapp.democompose.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.screens.home.state.Task
import com.demoapp.democompose.ui.theme.cardColor
import com.demoapp.democompose.ui.theme.hintColor
import com.demoapp.democompose.ui.theme.textColor

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    ItemTask()
}

@Composable
fun ItemTask(modifier: Modifier = Modifier, task: Task = Task()) {
    Card(
        modifier = modifier, shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(cardColor)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Divider(modifier = Modifier
                .width(2.dp)
                .height(35.dp))
            Column {
                Text(text = task.title, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = textColor)
                Text(text = buildAnnotatedString {
                    append(task.timeBegin)
                    append(" - ")
                    append(task.timeEnd)
                }, color = hintColor, fontSize = 14.sp)

            }
            Image(painter = painterResource(id = R.drawable.ic_more), contentDescription = "more")
        }
    }
}