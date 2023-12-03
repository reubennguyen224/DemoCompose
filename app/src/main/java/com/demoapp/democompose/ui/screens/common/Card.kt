package com.demoapp.democompose.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.theme.textColor
import com.demoapp.democompose.ui.theme.white

@Preview(showBackground = true)
@Composable
fun previewCard() {
    TaskCard(onClick = {}, label = "Completed")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    background: Painter = painterResource(id = R.drawable.bg_card_blue),
    icon: Painter = painterResource(id = R.drawable.ic_pc),
    label: String,
    isWhiteTextColor: Boolean = true,
    numberTask: Int = 0,
    height: Dp = 152.dp,
    needSpace: Boolean = false
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .padding(8.dp)
            .height(height)
            .width(155.dp)
            ,
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier.paint(background)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = icon,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(top = 10.dp, start = 14.dp)
                        .wrapContentHeight()
                )
                if (needSpace)
                    Spacer(modifier = Modifier.padding(28.dp))
                Image(
                    painter = painterResource(id = R.drawable.arrow___right),
                    contentDescription = "",
                    alignment = Alignment.TopEnd,
                    modifier = Modifier.padding(end = 15.dp, top = 15.dp),
                    colorFilter = ColorFilter.tint(if (isWhiteTextColor) white else textColor)
                )
            }

            Text(
                text = label, style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Medium, color = if (isWhiteTextColor) white else textColor
                ), modifier = Modifier.padding(start = 15.dp, top = 7.dp)
            )
            
            Text(text = buildAnnotatedString {
                append(numberTask.toString())
                append(" Task")
            }, modifier = Modifier.padding(start = 15.dp, top = 7.dp, bottom = 15.dp), style = TextStyle(
                fontSize = 14.sp, color = if (isWhiteTextColor) white else textColor)
            )
        }
    }
}