package com.demoapp.democompose.ui.screens.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demoapp.democompose.R
import com.demoapp.democompose.ui.theme.hintColor
import com.demoapp.democompose.ui.theme.lineColor
import com.demoapp.democompose.ui.theme.primaryColor
import com.demoapp.democompose.ui.theme.textColor
import com.demoapp.democompose.ui.theme.trans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    isError: Boolean = false,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Email,
    icon: Painter = painterResource(id = R.drawable.message)
) {
    TextField(
        value = text,
        textStyle = TextStyle(color = textColor),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        isError = isError,
        modifier = modifier,
        placeholder = {
            Text(text = label, color = hintColor)
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = trans,
            unfocusedIndicatorColor = lineColor,
            focusedIndicatorColor = primaryColor
        ),
        leadingIcon = {
            Icon(
                painter = icon,
                contentDescription = "Icon",
                tint = LocalContentColor.current.copy(alpha = 0.6f)
            )
        }, singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PasswordTextField(
    value: String,
    label: String = "",
    onValueChange: (String) -> Unit,
    isError: Boolean,
    imeAction: ImeAction = ImeAction.Done,
    modifier: Modifier = Modifier,
    isShowTrailingIcon: Boolean = true
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        isError = isError,
        placeholder = {
            Text(text = label, color = hintColor)
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = trans,
            unfocusedIndicatorColor = lineColor,
            focusedIndicatorColor = primaryColor
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.lock),
                contentDescription = "Icon",
                tint = LocalContentColor.current.copy(alpha = 0.6f)
            )
        },
        trailingIcon = {
            if (isShowTrailingIcon)
            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            }) {
                val visibleIcon = Icons.Outlined.Visibility
                val inVisibleIcon = Icons.Outlined.VisibilityOff
                val passwordIcon = if (isPasswordVisible) visibleIcon else inVisibleIcon
                Icon(
                    imageVector = passwordIcon,
                    contentDescription = "icon",
                    tint = LocalContentColor.current.copy(alpha = 0.6f),
                    modifier = Modifier.size(16.dp)
                )
            }
        },
        modifier = modifier,
        singleLine = true,
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextField() {
    Column {
        CustomTextField(
            text = "",
            onValueChange = {},
            label = "Test",
            modifier = Modifier.padding(12.dp)
        )
        PasswordTextField(
            value = "",
            onValueChange = {},
            isError = false,
            label = "Password",
            modifier = Modifier.padding(12.dp)
        )
    }
}