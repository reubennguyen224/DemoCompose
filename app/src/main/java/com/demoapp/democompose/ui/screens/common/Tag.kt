package com.demoapp.democompose.ui.screens.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.ui.theme.tagColor
import com.demoapp.democompose.ui.theme.tagTextColor

@Preview(showBackground = true)
@Composable
fun PreviewTag() {
    Tag(name = "Urgent")
}

@Composable
fun Tag(name: String) {
    Card(shape = RoundedCornerShape(3.dp), colors = CardDefaults.cardColors(tagColor), modifier = Modifier.padding(3.dp)) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                modifier = Modifier.padding(start = 7.dp, end = 7.dp, top = 2.dp, bottom = 2.dp),
                color = tagTextColor
            )
        }
    }
}