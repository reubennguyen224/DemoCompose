package com.demoapp.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.demoapp.democompose.ui.screens.common.BottomBarScreen
import com.demoapp.democompose.ui.screens.createtask.CreateTask
import com.demoapp.democompose.ui.screens.home.HomeScreen
import com.demoapp.democompose.ui.screens.task.TaskScreen
import com.demoapp.democompose.ui.theme.DemoComposeTheme
import com.demoapp.democompose.ui.theme.white

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoComposeTheme {
                // A surface container using the 'background' color from the theme
                HomeApp()
            }
        }
    }
}

@Composable
fun HomeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        BottomNav()
    }
}

@Composable
fun HomeAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController, modifier = modifier,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Document.route) {
            TaskScreen()
        }
        composable(route = BottomBarScreen.Create.route) {
            CreateTask()
        }
        composable(route = BottomBarScreen.Activity.route) {

        }
        composable(route = BottomBarScreen.Folder.route) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Modifier.padding(it)
        HomeAppNavHost(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Document,
        BottomBarScreen.Create,
        BottomBarScreen.Activity,
        BottomBarScreen.Folder
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Card(
        shape = RoundedCornerShape(14.dp), modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
            .background(white)
            .fillMaxWidth(), elevation = CardDefaults.outlinedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .background(white)
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    needIndicator: Boolean = true
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    Box(
        modifier = Modifier.clickable {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = if (selected) screen.icon_focused else screen.icon),
                contentDescription = "icon"
            )
            AnimatedVisibility(visible = selected) {
                if (screen !is BottomBarScreen.Create)
                    Image(
                        painter = painterResource(id = R.drawable.ic_dot),
                        contentDescription = "icon",
                        modifier = Modifier.align(
                            Alignment.CenterHorizontally
                        )
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    BottomNav()
}