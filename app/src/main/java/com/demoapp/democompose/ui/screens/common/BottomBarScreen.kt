package com.demoapp.democompose.ui.screens.common

import androidx.compose.runtime.Composable
import com.demoapp.democompose.R

sealed class BottomBarScreen(
    val route: String,
    val icon: Int,
    val icon_focused: Int
) {
    object Home: BottomBarScreen(
        route = "home",
        icon = R.drawable.ic_home,
        icon_focused = R.drawable.ic_home_selected
    )

    object Document: BottomBarScreen(
        route = "document",
        icon = R.drawable.ic_document,
        icon_focused = R.drawable.ic_document_selected
    )

    object Create: BottomBarScreen(
        route = "create",
        icon = R.drawable.ic_create,
        icon_focused = R.drawable.ic_create
    )

    object Activity: BottomBarScreen(
        route = "activity",
        icon = R.drawable.ic_activity,
        icon_focused = R.drawable.ic_activity
    )

    object Folder: BottomBarScreen(
        route = "folder",
        icon = R.drawable.ic_folders,
        icon_focused = R.drawable.ic_folders
    )
}
